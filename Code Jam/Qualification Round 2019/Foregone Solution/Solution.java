import java.util.Scanner;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        
        for (int currentTestCase = 0; currentTestCase < numTestCases; currentTestCase++) {
            int currentInt = sc.nextInt();
            int firstNum = currentInt / 2;
            int secondNum = (int) Math.ceil((double) currentInt / 2);
            boolean containsFour = false;
            
            do {
                List<Integer> seperateDigits = new LinkedList<Integer>();
            
                int i = firstNum;
                while (i > 0) {
                    seperateDigits.add(i % 10);
                    i /= 10;
                }
                
                if (seperateDigits.contains(4)) {
                    firstNum /= 2;
                    int j = secondNum;
                    secondNum = (int) Math.ceil((double) (secondNum + currentInt) / 2);
                    containsFour = true;
                }
                
                if (!containsFour) {
                    seperateDigits = new LinkedList<Integer>();
                    i = secondNum;
                    
                    while (i > 0) {
                        seperateDigits.add(i % 10);
                        i /= 10;
                    }
                    
                    if (seperateDigits.contains(4)) {
                        firstNum /= 2;
                        secondNum = (secondNum + currentInt) / 2;
                        containsFour = true;
                    }
                }
            } while (containsFour && firstNum > 0 && secondNum < currentInt);
            
            if (firstNum < 0 && secondNum > currentInt) {
                // test
                System.out.println("Error occured, out of bounds!");
            }
            
            System.out.println("Case #" + currentTestCase + ": " + firstNum + " " + secondNum);
        }
    }
}
