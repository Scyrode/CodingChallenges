import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        // I tried to solve this problem in O(N) time, but failed to do so
        // I attempted to create ranges of numbers such that we do not need
        // to iterate over the array of zeros updating all of the values that
        // fall within the current query. Instead, I attempted to find the
        // summation of all queries that relate to the current index, but
        // failed to make it work. We need a wa
        
        Map<Integer, Integer> numberMap = new TreeMap<>();
        int[] countArray = new int[n];

        for (int i = 0; i < queries.length; i++) {
            if (numberMap.containsKey(queries[i][0])) {
                numberMap.put(queries[i][0], numberMap.get(queries[i][0]) + queries[i][2]);
            } else {
                numberMap.put(queries[i][0], queries[i][2]);
            }
            if (numberMap.containsKey(queries[i][1])) {
                numberMap.put(queries[i][1], numberMap.get(queries[i][1]) + queries[i][2]);
            } else {
                numberMap.put(queries[i][1], queries[i][2]);
            }
        }

        int lastMetIndex = -1;

        for (int i = 0; i < countArray.length; i++) {
            if (lastMetIndex == -1 && !numberMap.containsKey(i+1)) {
                // nothing happens
            } else if (numberMap.containsKey(i+1)) {
                int prevValueOfLastMetIndex = lastMetIndex;
                lastMetIndex = i;
                if (prevValueOfLastMetIndex != -1) {
                    countArray[i] = numberMap.get(i+1) + numberMap.get(lastMetIndex+1);
                } else {
                    countArray[i] = numberMap.get(i+1);
                }
            } else {
                countArray[i] = numberMap.get(lastMetIndex+1);
            }
        }

        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] > maxValue) {
                maxValue = countArray[i];
            }
        }

        return maxValue;
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
