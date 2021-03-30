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
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] tempArray = new int[n];

        for (int i = 0; i < tempArray.length; i++) {
            int currentIndex = i - d;
            if (currentIndex < 0)
                currentIndex += n;
            tempArray[currentIndex] = a[i];
        }

        for (int i = 0; i < n-1; i++) {
            System.out.print(tempArray[i] + " ");
        }

        System.out.println(tempArray[n-1]);

        // no need to use a map to turn it into a O(N) operation
        // if we create a new empty array of the same size as array
        // 'a', then we can place the values at their updated index
        // immediately, instead of iterating over each value in 'a'
        // 'd' times

        /* // could use a Map<Integer, Integer> to store the values
        // and their changing index. Then, for each entry in the
        // map, update the values in 'a' according to their
        // modified index

        Map<Integer, List<Integer>> indexMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> tempList = new LinkedList<>();
            if (indexMap.containsKey(a[i])) {
                tempList = indexMap.get(a[i]);
            }
            tempList.add(i);
            indexMap.put(a[i], tempList);
        }

        indexMap.replaceAll((key, list) -> { list.replaceAll((value) -> { value -= d; if (value < 0) { value += n; } return value; }); return list; });

        indexMap.forEach((key, list) -> list.forEach((value) -> a[value] = key));

        for (int i = 0; i < n-1; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println(a[n-1]); */
        
        /* int[] tempArray = new int[n+1];

        for (int i = 0; i < n; i++) {
            tempArray[i] = a[i];
        }

        // due to the way java creates array, we do not need to specify
        // that the last value of the temp array is zero

        for (int i = 0; i < d; i++) {
            int temp = tempArray[0];
            tempArray[0] = tempArray[n];
            tempArray[n] = temp;
            
            for (int j = 0; j < n; j++) {
                temp = tempArray[j];
                tempArray[j] = tempArray[j+1];
                tempArray[j+1] = temp;
            }
        }

        for (int i = 0; i < n-1; i++) {
            a[i] = tempArray[i];
            System.out.print(a[i] + " ");
        }

        a[n-1] = tempArray[n-1];

        System.out.println(a[n-1]); */

        scanner.close();
    }
}
