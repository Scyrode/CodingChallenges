import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] tokens = s.split("[\\s!,?._'@]+");
        int numTokens = tokens.length;
        System.out.println(numTokens);
        for (int i = 0; i < numTokens; i++) {
            System.out.println(tokens[i]);
        }
        scan.close();
    }
}

