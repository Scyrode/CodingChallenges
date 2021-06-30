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
        String n = scanner.nextLine();

        BigInteger bigInteger =  new BigInteger(n);

        System.out.println(bigInteger.isProbablePrime(2) ? "prime" : "not prime");

        scanner.close();
    }
}
