import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    static boolean isAnagram(String a, String b) {
        
        if (a.length() != b.length()) {
            return false;
        }

        String lowerCaseA = "";
        String lowerCaseB = "";

        Map<Character, Integer> occurencesInA = new HashMap<Character, Integer>();
        Map<Character, Integer> occurencesInB = new HashMap<Character, Integer>();

        for (int i = 0; i < a.length(); i++) {
            lowerCaseA += Character.toLowerCase(a.charAt(i));
            char currentChar = lowerCaseA.charAt(i);
            if (occurencesInA.containsKey(currentChar)) {
                int currentOccurences = occurencesInA.get(currentChar);
                occurencesInA.replace(currentChar, currentOccurences + 1);
            } else {
                occurencesInA.put(currentChar, 1);
            }
        }

        for (int i = 0; i < b.length(); i++) {
            lowerCaseB += Character.toLowerCase(b.charAt(i));
            char currentChar = lowerCaseB.charAt(i);
            if (occurencesInB.containsKey(currentChar)) {
                int currentOccurences = occurencesInB.get(currentChar);
                occurencesInB.replace(currentChar, currentOccurences + 1);
            } else {
                occurencesInB.put(currentChar, 1);
            }
        }

        if (occurencesInA.equals(occurencesInB)) {
            return true;
        } else {
            return false;
        }

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