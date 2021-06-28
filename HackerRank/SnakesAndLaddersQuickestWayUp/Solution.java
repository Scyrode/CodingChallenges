import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the quickestWayUp function below.
    static int quickestWayUp(int[][] ladders, int[][] snakes) {
        boolean[] visited = new boolean[100];
        Map<Integer, Integer> laddersMap = new HashMap<>();
        Map<Integer, Integer> snakesMap = new HashMap<>();

        for (int[] ladder : ladders) {
            laddersMap.put(ladder[0], ladder[1]);
        }
        
        for (int[] snake : snakes) {
            snakesMap.put(snake[0], snake[1]);
        }
        
        return findQuickestWayUp(0, -1, laddersMap, snakesMap, visited);
    }

    private static int findQuickestWayUp(int currIndex, int sum, Map<Integer, Integer> laddersMap, Map<Integer, Integer> snakesMap, boolean[] visited) {
        if (currIndex > 99) {
            return -1;
        }
        
        // if on start of ladder, climb it
        if (laddersMap.containsKey(currIndex)) {
            currIndex = laddersMap.get(currIndex);
        }

        // if on mouth of snake, go down it
        if (snakesMap.containsKey(currIndex)) {
            currIndex = snakesMap.get(currIndex);
        }

        if (visited[currIndex]) {
            return -1;
        }
        
        int currSum = findQuickestWayUp(currIndex+6, sum, laddersMap, snakesMap, visited);
        if (currSum != -1) {
            if (sum != -1) {
                sum = Math.min(sum, currSum);
            } else {
                sum = currSum;
            }
        }

        currSum = findQuickestWayUp(currIndex+5, sum, laddersMap, snakesMap, visited);
        if (currSum != -1) {
            if (sum != -1) {
                sum = Math.min(sum, currSum);
            } else {
                sum = currSum;
            }
        }

        currSum = findQuickestWayUp(currIndex+4, sum, laddersMap, snakesMap, visited);
        if (currSum != -1) {
            if (sum != -1) {
                sum = Math.min(sum, currSum);
            } else {
                sum = currSum;
            }
        }

        currSum = findQuickestWayUp(currIndex+3, sum, laddersMap, snakesMap, visited);
        if (currSum != -1) {
            if (sum != -1) {
                sum = Math.min(sum, currSum);
            } else {
                sum = currSum;
            }
        }

        currSum = findQuickestWayUp(currIndex+2, sum, laddersMap, snakesMap, visited);
        if (currSum != -1) {
            if (sum != -1) {
                sum = Math.min(sum, currSum);
            } else {
                sum = currSum;
            }
        }

        currSum = findQuickestWayUp(currIndex+1, sum, laddersMap, snakesMap, visited);
        if (currSum != -1) {
            if (sum != -1) {
                sum = Math.min(sum, currSum);
            } else {
                sum = currSum;
            }
        }

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] ladders = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] laddersRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int laddersItem = Integer.parseInt(laddersRowItems[j]);
                    ladders[i][j] = laddersItem;
                }
            }

            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] snakes = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] snakesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int snakesItem = Integer.parseInt(snakesRowItems[j]);
                    snakes[i][j] = snakesItem;
                }
            }

            int result = quickestWayUp(ladders, snakes);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
