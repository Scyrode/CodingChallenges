import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int maxSum = Integer.MIN_VALUE;

        for (int rowIndex = 0; rowIndex < 4; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 4; columnIndex++) {
                int currentSum = arr[rowIndex][columnIndex] + arr[rowIndex][columnIndex+1] + arr[rowIndex][columnIndex+2] + arr[rowIndex+1][columnIndex+1] + arr[rowIndex+2][columnIndex] + arr[rowIndex+2][columnIndex+1] + arr[rowIndex+2][columnIndex+2];

                if (currentSum > maxSum)
                    maxSum = currentSum;
            }
        }

        System.out.println(maxSum);

        scanner.close();
    }
}
