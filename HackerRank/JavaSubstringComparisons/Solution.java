import java.util.Scanner;

public class Solution {

    private static String getSmallestAndLargest(String s, int k) {
        int firstIndex = 0;
        int secondIndex = k;

        String smallestSubS = s.substring(firstIndex, secondIndex);
        String largestSubS = s.substring(firstIndex, secondIndex);

        firstIndex++;
        secondIndex++;

        do {
            String newSubS = s.substring(firstIndex, secondIndex);

            // for each newSubS, we need to check if its smaller than the smallest
            // subString or larger than the largest subString. If it is smaller than the
            // smallest subString, no need to check if it is larger than the largest
            // subString
            int counter = 0;
            while (counter < newSubS.length() && smallestSubS.charAt(counter) == newSubS.charAt(counter)) {
                counter++;
            }

            if (counter < newSubS.length() && newSubS.charAt(counter) < smallestSubS.charAt(counter)) {
                smallestSubS = newSubS;
            } else {
                counter = 0;
                
                while (counter < newSubS.length() && largestSubS.charAt(counter) == newSubS.charAt(counter)) {
                    counter++;
                }

                if (counter < newSubS.length() && newSubS.charAt(counter) > largestSubS.charAt(counter)) {
                    largestSubS = newSubS;
                }
            }

            firstIndex++;
            secondIndex++;
        } while (secondIndex <= s.length());

        return smallestSubS + "\n" + largestSubS;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}
