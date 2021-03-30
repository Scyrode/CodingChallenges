import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int currentRow = 1;
        int[] indices = new int[7];

        int maxSum = Integer.MIN_VALUE;

        do {

            // intialise indices
            indices[0] = 0;
            indices[1] = 1;
            indices[2] = 2;
            indices[3] = 1;
            indices[4] = 0;
            indices[5] = 1;
            indices[6] = 2;
            
            while (indices[2] < 6) {
                int currentSum = 0;
                
                for (int i = 0; i < 3; i++) {
                    currentSum += arr[currentRow-1][indices[i]];
                }

                for (int i = 3; i < 4; i++) {
                    currentSum += arr[currentRow][indices[i]];
                }

                for (int i = 4; i < indices.length; i++) {
                    currentSum += arr[currentRow+1][indices[i]];
                }

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }

                for (int i = 0; i < indices.length; i++) {
                    indices[i]++;
                }
            }

            currentRow++;
        } while (currentRow < 5);

        return maxSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
