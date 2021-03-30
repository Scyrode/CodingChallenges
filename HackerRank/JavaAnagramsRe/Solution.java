import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        int[] aOccuurrences = new int[27];
        int[] bOccuurrences = new int[27];

        if (a.length() != b.length())
            return false;

        for (int i = 0; i < a.length(); i++) {
            char currentChar = Character.toLowerCase(a.charAt(i));
            aOccuurrences[currentChar - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            char currentChar = Character.toLowerCase(b.charAt(i));
            bOccuurrences[currentChar - 'a']++;
        }

        for (int i = 0; i < aOccuurrences.length; i++) {
            if (aOccuurrences[i] != bOccuurrences[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}