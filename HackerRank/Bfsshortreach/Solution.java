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
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        List<Integer> output = new ArrayList<>();
        Map<Integer, Integer> weightMap = new TreeMap<>();
        List<Integer> queue = new ArrayList<>();
        Map<Integer, List<Integer>> nodeMap = new TreeMap<>();

        for (List<Integer> edgePair : edges) {
            if (!nodeMap.containsKey(edgePair.get(0))) {
                nodeMap.put(edgePair.get(0), new ArrayList<>());
            }
            nodeMap.get(edgePair.get(0)).add(edgePair.get(1));
        }

        for (int i = 1; i <= n; i++) {
            if (!nodeMap.containsKey(i)) {
                nodeMap.put(i, new ArrayList<>());
                nodeMap.get(i).add(-1);
            }
        }

        int currentWeight = 6;
        queue.add(s);

        do {
            boolean edgesFound = true;
            for (Integer integer : nodeMap.get(queue.get(0))) {
                if (integer != -1) {
                    weightMap.put(integer, currentWeight);
                    queue.add(integer);
                } else {
                    edgesFound = false;
                }
            }

            if (edgesFound) {
                currentWeight += 6;
            }

            nodeMap.remove(queue.get(0));
            queue.remove(0);
        } while (!queue.isEmpty());

        for (int i = 1; i <= n; i++) {
            if (i != s) {
                if (weightMap.containsKey(i)) {
                    output.add(weightMap.get(i));
                } else {
                    output.add(-1);
                }
            }
        }

        return output;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.bfs(n, m, edges, s);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
