import java.util.Scanner;

/**
 * Solution
 * Completely wrong implementation... did not read the examples and its answers
 * 
 */
public class Solution {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int numTestCases = sc.nextInt();
        for (int currentTestCase = 1; currentTestCase <= numTestCases; currentTestCase++) {
            int maxSumBeautyValues = findSumBeautyValues();
            System.out.println("Case #" + currentTestCase + ": " + maxSumBeautyValues);
        }

        sc.close();
    }

    public static int findSumBeautyValues() {
        int numStacks = sc.nextInt();
        int numPlates = sc.nextInt();
        int numChosenPlates = sc.nextInt();
        int remainingPlates = numChosenPlates;
        int totalBeautyValues = 0;

        int[][] stacks = new int[numStacks][numPlates];
        
        // read stacks into 2D array
        for (int i = 0; i < numStacks; i++) {
            for (int j = 0; j < numPlates; j++) {
                stacks[i][j] = sc.nextInt();
            }
        }

        /* 
        - if P > K, find the stack with the greatest total and add those to the Primary stack
        - if new P > K, repeat
        - if P < K, search through the stack and find the stack with the max sum till K
        */
        int[] eleminatedStacks = new int[numStacks];
        while (remainingPlates > numPlates) {
            int stackToEleminate = 0;
            int maxSum = 0;
            for (int currentStackIndex = 0; currentStackIndex < numStacks; currentStackIndex++) {
                int sumOfStack = 0;
                for (int currentPlateIndex = 0; currentPlateIndex < numPlates; currentPlateIndex++) {
                    sumOfStack += stacks[currentStackIndex][currentPlateIndex];
                }

                if (sumOfStack > maxSum) {
                    maxSum = sumOfStack;
                    stackToEleminate = currentStackIndex;
                }
            }

            totalBeautyValues += maxSum;
            
            eleminatedStacks[stackToEleminate]++;
            remainingPlates -= numPlates;
        }

        // now that the remaining plates are less than the number of plates in a stack
        // we must traverse through each stack searching for the stack with the greatest
        // beauty value sum and add that to the total beauty sum
        int maxStackSum = 0;
        for (int i = 0; i < numStacks; i++) {
            // if the stack is eleminated, dont check for max beauty sum value
            if (eleminatedStacks[i] == 0) {
                int currentStackSum = 0;
                for (int j = 0; j < remainingPlates; j++) {
                    currentStackSum += stacks[i][j];
                }

                if(currentStackSum > maxStackSum) {
                    maxStackSum = currentStackSum;
                }
            }
        }

        totalBeautyValues += maxStackSum;
        
        return totalBeautyValues;
    }
}