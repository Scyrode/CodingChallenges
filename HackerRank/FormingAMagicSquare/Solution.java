import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int largestSum = 0;

        int[] frequencies = new int[10];
        // store the number frequencies in matrix
        for (int[] row : s) {
            for (int i : row) {
                frequencies[i]++;
            }
        }

        // find the largest existing sum from the rows, columns and diagonals
        // rows
        for (int i = 0; i < 3; i++) {
            int currentSum = s[i][0] + s[i][1] + s[i][2];
            if(largestSum < currentSum) {
                largestSum = currentSum;
            }
        }

        // columns
        for (int i = 0; i < 3; i++) {
            int currentSum = s[0][i] + s[1][i] + s[2][i];
            if(largestSum < currentSum) {
                largestSum = currentSum;
            }
        }

        // left diagonal
        if (largestSum < s[0][0] + s[1][1] + s[2][2]) {
            largestSum = s[0][0] + s[1][1] + s[2][2];
        }

        // right diagonal
        if (largestSum < s[0][2] + s[1][1] + s[2][0]) {
            largestSum = s[0][2] + s[1][1] + s[2][0];
        }

        // test
        // System.out.println(largestSum);

        // once the largest sum is found, we take a greedy approach: each row, column and diagonal checks whether it has
        // the largest sum or not. If it is smaller, it converts any duplicate numbers inside of it to be equal to the
        // largest sum. If converting a single number does not result in the largest sum, convert the next smallest number
        // to a number that does not exist inside of it and that results in the largest number.
        int[] matrixSums = new int[8];

        int cost = 0;

        while (matrixSums[0] != largestSum || matrixSums[1] != largestSum || matrixSums[2] != largestSum) {
            // rows... do we need to just fix the rows?
            for (int i = 0; i < 3; i++) {
                int counter = 0;
                int currentSum = 0;
                for (int j = 0; j < 3; j++) {
                    currentSum += s[i][j];
                }
                // test
                System.out.println(currentSum);
                if (currentSum != largestSum) {
                    for (int j = 0; j < 3; j++) {
                        if (frequencies[s[i][j]] > 1) {
                            int difference = largestSum - currentSum;
                            frequencies[s[i][j]]--;
                            if (difference > 9) {
                                difference = 9 - counter - s[i][j];
                                s[i][j] = 9 - counter;
                                counter++;
                            } else {
                                s[i][j] += difference;
                                if (s[i][j] > 9) {
                                    difference = 9 - s[i][j];
                                    s[i][j] = 9;
                                }
                            }
                            cost += difference;
                            currentSum += difference;
                            frequencies[s[i][j]]++;
                        }
                    }
                }
            }

            matrixSums[0] = s[0][0] + s[0][1] + s[0][2];
            matrixSums[1] = s[1][0] + s[1][1] + s[1][2];
            matrixSums[2] = s[2][0] + s[2][1] + s[2][2];
            matrixSums[3] = s[0][0] + s[1][0] + s[2][0];
            matrixSums[4] = s[0][1] + s[1][1] + s[2][1];
            matrixSums[5] = s[0][2] + s[1][2] + s[2][2];
            matrixSums[6] = s[0][0] + s[1][1] + s[2][2];
            matrixSums[7] = s[0][2] + s[1][1] + s[2][0];
        }

        return cost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
