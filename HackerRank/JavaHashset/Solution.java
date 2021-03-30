import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        Set<String> set = new HashSet<>();
        int numOfUniquePairs = 0;
        
        for (int i = 0; i < pair_left.length; i++) {
            if (set.add(pair_left[i] + " " + pair_right[i])) {
                numOfUniquePairs++;
            }

            System.out.println(numOfUniquePairs);
        }
    }
}