import java.util.Scanner;
import java.util.Arrays;

/* Approaches:
    - Sort data
        - add elemets till index where sum < B*/

/**
 * Solution
 */
public class Solution {
    public static void main(String[] args) {
        // read input from screen
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();

        for (int currentTestCase = 1; currentTestCase <= numTestCases; currentTestCase++) {

            int numOfHouses = sc.nextInt();
            int budget = sc.nextInt();
            int currentHouseIndex = 0;
            int houseCostsSum = 0;
            
            if (numOfHouses != 0 && budget != 0) {
                int[] houseCosts = new int[numOfHouses];
                for (int currentHouse = 0; currentHouse < numOfHouses; currentHouse++) {
                    houseCosts[currentHouse] = sc.nextInt();
                }

                // sort the list of houses then find the index at which the sum is
                // less than the available budget
                Arrays.sort(houseCosts);

                if (budget != 0 && numOfHouses != 0) {
                    while (houseCostsSum <= budget) {
                        houseCostsSum += houseCosts[currentHouseIndex];
                        currentHouseIndex++;
                    }
                }
            }
            
            System.out.println("Case #" + currentTestCase + ": " + Integer.toString(currentHouseIndex - 1));
        }

        sc.close();
    }
}