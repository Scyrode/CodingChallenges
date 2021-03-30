import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        if ((x1 > x2 && v1 >= v2) || (x2 > x1 && v2 >= v1)) {
            return "NO";
        }

        boolean x1IsBehind = x1 < x2;
        boolean x1IsCurrentlyBehind = x1IsBehind;
        
        while (x1 < Integer.MAX_VALUE && x2 < Integer.MAX_VALUE) {
            x1 += v1;
            x2 += v2;

            // test
            System.out.println("Hopping");

            x1IsCurrentlyBehind = x1 < x2;

            if (x1 == x2) {
                return "YES";
            }

            if (x1IsBehind != x1IsCurrentlyBehind) {
                return "NO";
            }
        }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
