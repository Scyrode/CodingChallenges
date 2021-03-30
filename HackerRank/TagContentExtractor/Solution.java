import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();
            
            Pattern pattern = Pattern.compile("<(.+)>([^<>]+)</\\1>");

            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                do {
                    System.out.println(matcher.group(2));
                } while (matcher.find());
            } else {
                System.out.println("None");
            }
            
            testCases--;
        }
    }
}