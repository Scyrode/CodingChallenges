/*
Problem: Print all sub-arrays with 0 sum
given array: {4,2,-3,-1,0,4}
	sub arrays:
	{4,-3,-1,0}
	{0}

Comments:
- Order does not matter for a given number of terms (i.e for {3,4,-7}, that's the only sub-array that = 0)
- we are not looking for all combinations of the terms in the array that equal to zero, but rather subsequent
	terms that add up to 0

Approach:
- we need to create a 2D array that has a width of the # of elements
	and a height the number of possible combinations (since we are using arrays)
- for each term, we add the terms after it until we reach a sum of zero or the end of the array
	- if we reach a sum of zero, we record that array as a correct sub-set
	- if we reach the end of the array, if the sum of terms is zero, we record it as a correct sub-set then
		whether it was a correct sub-set or not we move to the next term

*/

public class Solution
{
	public int[][] findSubTermsAddToZero(int[] array)
	{
		// most memory conservative solution would calculate the number
		// of possible sub-array combinations there are and make the
		// height of the 2D array be equal to the # of combinations
		// for simplicity, we will make the height a very large number
		
		int [][] subArrays = new int[10000][array.length];
		int [] currentArray = new int[array.length];
		int currentArrayIndex = 0;
		boolean isValidSubArray = false;

		for (int initialTerm = 0; initialTerm < array.length; initialTerm++)
		{
			int upperBoundTerm = initialTerm;
			while (upperBoundTerm < array.length - 1)
			{
				int sumOfTerms = 0;
				
				for (int counter = 0; counter <= (upperBoundTerm - initialTerm); counter++)
				{
					currentArray[counter] = array[initialTerm + counter];
				}

				for (int counter = 0; counter < (upperBoundTerm - initialTerm); counter++)
				{
					sumOfTerms += currentArray[counter];
				}

				if (sumOfTerms == 0)
					isValidSubArray = true;
				else
					isValidSubArray = false;

				if (isValidSubArray)
				{
					for (int counter = 0; counter < currentArray.length; counter++)
					{
						subArrays[currentArrayIndex][counter] = currentArray[counter];
					}
					
					currentArrayIndex++;
				}

				upperBoundTerm++;
			}
		}

		return subArrays;
	}
}