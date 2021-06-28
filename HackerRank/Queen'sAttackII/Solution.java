import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        int queenR = r_q-1;
        int queenC = c_q-1;
        
        Set<List<Integer>> validMovementsSet = new HashSet<>();
        Set<List<Integer>> obstacleSet = new HashSet<>();

        for (List<Integer> obstacle : obstacles) {
            if (!obstacleSet.contains(obstacle)) {
                obstacleSet.add(obstacle);
            }
        }

        // decrement all the obstacle positions
        for (List<Integer> obstacle : obstacles) {
            obstacle.set(0, obstacle.get(0) - 1);
            obstacle.set(1, obstacle.get(1) - 1);
        }

        // test
        System.out.println("possible movements from Queen's position to the right:");

        // add all the possible movements from Queen's position to the right
        int i = queenR, j = queenC+1;

        while (j < n) {
            // test
            System.out.println("Possible move: (" + (i+1) + ", " + (j+1) + ")");
            
            List<Integer> possibleMove = new ArrayList<>();

            possibleMove.add(i);
            possibleMove.add(j);

            validMovementsSet.add(possibleMove);
            
            j++;
        }

        // test
        System.out.println("possible movements from Queen's position through the bottom right diagonal:");

        // add all the possible movements from Queen's position through the bottom right diagonal
        i = queenR-1; j = queenC+1;

        while (i >= 0 && j < n) {
            // test
            System.out.println("Possible move: (" + (i+1) + ", " + (j+1) + ")");
            
            List<Integer> possibleMove = new ArrayList<>();

            possibleMove.add(i);
            possibleMove.add(j);

            validMovementsSet.add(possibleMove);
            
            i--;
            j++;
        }

        // test
        System.out.println("possible movements from Queen's position to the bottom:");

        // add all the possible movements from Queen's position to the bottom
        i = queenR-1; j = queenC;

        while (i >= 0) {
            // test
            System.out.println("Possible move: (" + (i+1) + ", " + (j+1) + ")");

            List<Integer> possibleMove = new ArrayList<>();

            possibleMove.add(i);
            possibleMove.add(j);

            validMovementsSet.add(possibleMove);
            
            i--;
        }

        // test
        System.out.println("possible movements from Queen's position through the bottom left diagonal:");

        // add all the possible movements from Queen's position through the bottom left diagonal
        i = queenR-1; j = queenC-1;

        while (i >= 0 && j >= 0) {
            // test
            System.out.println("Possible move: (" + (i+1) + ", " + (j+1) + ")");
            
            List<Integer> possibleMove = new ArrayList<>();

            possibleMove.add(i);
            possibleMove.add(j);

            validMovementsSet.add(possibleMove);
            
            i--;
            j--;
        }

        // test
        System.out.println("possible movements from Queen's position to the left:");

        // add all the possible movements from Queen's position to the left
        i = queenR; j = queenC-1;

        while (j >= 0) {
            // test
            System.out.println("Possible move: (" + (i+1) + ", " + (j+1) + ")");
            
            List<Integer> possibleMove = new ArrayList<>();

            possibleMove.add(i);
            possibleMove.add(j);

            validMovementsSet.add(possibleMove);
            
            j--;
        }

        // test
        System.out.println("possible movements from Queen's position to the top left diagonal:");

        // add all the possible movements from Queen's position to the top left diagonal
        i = queenR+1; j = queenC-1;

        while (i < n && j >= 0) {
            // test
            System.out.println("Possible move: (" + (i+1) + ", " + (j+1) + ")");
            
            List<Integer> possibleMove = new ArrayList<>();

            possibleMove.add(i);
            possibleMove.add(j);

            validMovementsSet.add(possibleMove);

            i++;
            j--;
        }

        // test
        System.out.println("possible movements from Queen's position to the top:");

        // add all the possible movements from Queen's position to the top
        i = queenR+1; j = queenC;

        while (i < n) {
            // test
            System.out.println("Possible move: (" + (i+1) + ", " + (j+1) + ")");
            
            List<Integer> possibleMove = new ArrayList<>();

            possibleMove.add(i);
            possibleMove.add(j);

            validMovementsSet.add(possibleMove);
            
            i++;
        }

        // test
        System.out.println("possible movements from Queen's position to the top right diagonal:");

        // add all the possible movements from Queen's position to the top right diagonal
        i = queenR+1; j = queenC+1;

        while (i < n && j < n) {
            // test
            System.out.println("Possible move: (" + (i+1) + ", " + (j+1) + ")");
            
            List<Integer> possibleMove = new ArrayList<>();

            possibleMove.add(i);
            possibleMove.add(j);

            validMovementsSet.add(possibleMove);

            i++;
            j++;
        }

        // check if an obstacle exists on a possible move, if it does, then remove the possible
        // move from the movement set
        for (List<Integer> obstacle : obstacles) {
            if (validMovementsSet.contains(obstacle)) {
                validMovementsSet.remove(obstacle);
                if (obstacle.get(0) == (queenR) && obstacle.get(1) > (queenC)) {
                    // remove all the possible movements from Queen's position to the right
                    i = obstacle.get(0); j = obstacle.get(1)+1;

                    while (j < n) {
                        List<Integer> possibleMove = new ArrayList<>();

                        possibleMove.add(i);
                        possibleMove.add(j);

                        validMovementsSet.remove(possibleMove);

                        j++;
                    }
                } else if (obstacle.get(0) < (queenR) && obstacle.get(1) > (queenC)) {
                    // remove all the possible movements from Queen's position through the bottom right diagonal
                    i = obstacle.get(0)-1; j = obstacle.get(1)+1;

                    while (i >= 0 && j < n) {
                        List<Integer> possibleMove = new ArrayList<>();

                        possibleMove.add(i);
                        possibleMove.add(j);

                        validMovementsSet.remove(possibleMove);
                        
                        i--;
                        j++;
                    }
                } else if (obstacle.get(0) < (queenR) && obstacle.get(1) == (queenC)) {
                    // remove all the possible movements from Queen's position to the bottom
                    i = obstacle.get(0)-1; j = obstacle.get(1);

                    while (i >= 0) {
                        List<Integer> possibleMove = new ArrayList<>();

                        possibleMove.add(i);
                        possibleMove.add(j);

                        validMovementsSet.remove(possibleMove);
                        
                        i--;
                    }
                } else if (obstacle.get(0) < (queenR) && obstacle.get(1) < (queenC)) {
                    // remove all the possible movements from Queen's position through the bottom left diagonal
                    i = obstacle.get(0)-1; j = obstacle.get(1)-1;

                    while (i >= 0 && j >= 0) {
                        List<Integer> possibleMove = new ArrayList<>();

                        possibleMove.add(i);
                        possibleMove.add(j);

                        validMovementsSet.remove(possibleMove);
                        
                        i--;
                        j--;
                    }
                } else if (obstacle.get(0) == (queenR) && obstacle.get(1) < (queenC)) {
                    // remove all the possible movements from Queen's position to the left
                    i = obstacle.get(0); j = obstacle.get(1)-1;

                    while (j >= 0) {
                        List<Integer> possibleMove = new ArrayList<>();

                        possibleMove.add(i);
                        possibleMove.add(j);

                        validMovementsSet.remove(possibleMove);
                        
                        j--;
                    }
                } else if (obstacle.get(0) > (queenR) && obstacle.get(1) < (queenC)) {
                    // remove all the possible movements from Queen's position to the top left diagonal
                    i = obstacle.get(0)+1; j = obstacle.get(1)-1;

                    while (i < n && j >= 0) {
                        List<Integer> possibleMove = new ArrayList<>();

                        possibleMove.add(i);
                        possibleMove.add(j);

                        validMovementsSet.remove(possibleMove);

                        i++;
                        j--;
                    }
                } else if (obstacle.get(0) > (queenR) && obstacle.get(1) == (queenC)) {
                    // remove all the possible movements from Queen's position to the top
                    i = obstacle.get(0)+1; j = obstacle.get(1);

                    while (i < n) {
                        List<Integer> possibleMove = new ArrayList<>();

                        possibleMove.add(i);
                        possibleMove.add(j);

                        validMovementsSet.remove(possibleMove);
                        
                        i++;
                    }
                } else if (obstacle.get(0) > (queenR) && obstacle.get(1) > (queenC)) {
                    // remove all the possible movements from Queen's position to the top right diagonal
                    i = obstacle.get(0)+1; j = obstacle.get(1)+1;

                    while (i < n && j < n) {
                        List<Integer> possibleMove = new ArrayList<>();

                        possibleMove.add(i);
                        possibleMove.add(j);

                        validMovementsSet.remove(possibleMove);

                        i++;
                        j++;
                    }
                }
            }
        }

        System.out.println();

        for (List<Integer> move : validMovementsSet) {
            System.out.println("valid move: (" + (move.get(0)+1) + ", " + (move.get(1)+1) + ")");
        }

        return validMovementsSet.size();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
