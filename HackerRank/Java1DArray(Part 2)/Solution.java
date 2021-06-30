import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        int currentIndex = 0;
        int startOfLeapIndex = 0;
        int numOfLeaps = 0;
        boolean resetToLeapPos = false;

        while (numOfLeaps >= 0 && currentIndex >= 0) {
            game[currentIndex] = 2;
            if (currentIndex+1 >= game.length || currentIndex+leap >= game.length)
                return true;
            else if (leap > 1 && game[currentIndex+leap] == 0) {
                // test
                // System.out.println("Leaping");
                currentIndex += leap;
                startOfLeapIndex = currentIndex;
                numOfLeaps++;
                resetToLeapPos = false;
            } else if (game[currentIndex+1] == 0) {
                // test
                // System.out.println("Move Forward");
                currentIndex++;
            } else if (!resetToLeapPos) {
                resetToLeapPos = true;
                currentIndex = startOfLeapIndex;
            } else if (currentIndex > 0 && game[currentIndex-1] == 0) {
                // test
                // System.out.println("Move Backward");
                currentIndex--;
            }
            else {
                startOfLeapIndex =- leap;
                numOfLeaps--;
                currentIndex = startOfLeapIndex;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
