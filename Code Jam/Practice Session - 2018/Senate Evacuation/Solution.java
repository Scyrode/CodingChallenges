import java.util.Scanner;

/**
 * Solution
 */
public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();

        for (int i = 0; i < numTestCases; i++)
        {

            int numParties = sc.nextInt();
            int[] senatesArray = new int[numParties];

            for (int j = 0; j < numParties; j++)
            {
                senatesArray[i] = sc.nextInt();
            }

            System.out.print("Case #" + i + ": ");

            outputEvacuationPlan(senatesArray);

            System.out.println();
            
        }

        sc.close();
        System.exit(0);
        
    }

    private static void outputEvacuationPlan(int[] senatesArray)
    {

        int greatestIndex = firstBiggestParty(senatesArray);
        int secondGreatestIndex = secondBiggestParty(senatesArray, greatestIndex);

        // ASCII value for A : 65
        char characterToPrint;

        if (senatesArray[greatestIndex] == 0)
        {
            return;
        } else if (senatesArray[greatestIndex] == senatesArray[secondGreatestIndex])
        {
            
            characterToPrint = (char) ('A' + greatestIndex);
            System.out.print(characterToPrint);
            senatesArray[greatestIndex]--;

            characterToPrint = (char) ('A' + secondGreatestIndex);
            System.out.print(characterToPrint + " ");
            senatesArray[secondGreatestIndex]--;

            outputEvacuationPlan(senatesArray);
            
        } else
        {

            characterToPrint = (char) ('A' + greatestIndex);
            System.out.print(characterToPrint + characterToPrint);
            senatesArray[greatestIndex] = senatesArray[greatestIndex] - 2;

            outputEvacuationPlan(senatesArray);
            
        }
        
    }

    private static int firstBiggestParty(int[] senatesArray) {

        int greatestIndex = 0;
        
        for (int i = 0; i < senatesArray.length; i++)
        {
            if (senatesArray[greatestIndex] < senatesArray[i])
            {
                greatestIndex = i;
            }
        }

        return greatestIndex;

    }

    private static int secondBiggestParty(int[] senatesArray, int greatestIndex) {

        int secondGreatestIndex = 0;

        for (int i = 0; i < senatesArray.length; i++)
        {
            if (i == greatestIndex) {}
            else if (senatesArray[secondGreatestIndex] < senatesArray[i])
            {
                secondGreatestIndex = i;
            }
        }

        return secondGreatestIndex;

    }
    
}