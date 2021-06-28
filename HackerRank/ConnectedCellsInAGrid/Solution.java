import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix) {
        int max = 0;
        int numOfRows = matrix.length;
        int numOfColumns = matrix[0].length;
        boolean[][] visited = new boolean[numOfRows][numOfColumns];
        
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] != 0 && visited[row][column] == false) {
                    max = Math.max(max, sizeOfCurrentRegion(row, column, numOfRows, numOfColumns, matrix, visited));
                }
            }
        }

        return max;
    }

    private static int sizeOfCurrentRegion(int row, int column, int numOfRows, int numOfColumns, int[][] matrix, boolean[][] visited) {
        if (row < 0 || column < 0 || row > (numOfRows-1) || column > (numOfColumns-1) || matrix[row][column] == 0 || visited[row][column] == true) 
            return 0;
        int sum = 1;
        visited[row][column] = true;
        sum += sizeOfCurrentRegion(row+1, column, numOfRows, numOfColumns, matrix, visited);
        sum += sizeOfCurrentRegion(row+1, column-1, numOfRows, numOfColumns, matrix, visited);
        sum += sizeOfCurrentRegion(row, column-1, numOfRows, numOfColumns, matrix, visited);
        sum += sizeOfCurrentRegion(row-1, column-1, numOfRows, numOfColumns, matrix, visited);
        sum += sizeOfCurrentRegion(row-1, column, numOfRows, numOfColumns, matrix, visited);
        sum += sizeOfCurrentRegion(row-1, column+1, numOfRows, numOfColumns, matrix, visited);
        sum += sizeOfCurrentRegion(row, column+1, numOfRows, numOfColumns, matrix, visited);
        sum += sizeOfCurrentRegion(row+1, column+1, numOfRows, numOfColumns, matrix, visited);
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
