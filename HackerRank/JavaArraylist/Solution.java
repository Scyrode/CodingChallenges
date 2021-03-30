import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            arrays.add(new ArrayList<Integer>());
            
            int d = sc.nextInt();

            if (d > 0) {
                for (int j = 0; j < d; j++) {
                    arrays.get(i).add(sc.nextInt());
                }
            }
        }

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            try {
                int x = sc.nextInt();
                int y= sc.nextInt();
                System.out.println(arrays.get(x-1).get(y-1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }

        sc.close();
    }
}