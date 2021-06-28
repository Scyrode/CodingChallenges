import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumLoss function below.
    static int minimumLoss(long[] price) {
        TreeSet<Long> set = new TreeSet<Long>();
        long result = Long.MAX_VALUE;
        for (Long curr : price) {
            if (!set.isEmpty() && set.last() > curr) {
                // test
                // System.out.print("Curr: " + curr + " ");
                // System.out.print("Last: " + set.last() + " ");
                // System.out.println("Higher: " + set.higher(curr));
                result = Math.min(result, set.higher(curr) - curr);
            }
            set.add(curr);
        }

        return (int) result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] price = new long[n];

        String[] priceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceItems[i]);
            price[i] = priceItem;
        }

        int result = minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
