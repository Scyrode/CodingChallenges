/*
Problem: Given an array of 1s and 0s, find max length sub-array having equal number of 1s and 0s
i.e : {0,0,1,0,1,1,0,1,0}
result : {0,0,1,0,1,1,0,1}

Comments:
- Sub-array means a contiguous array

Approach:
- Naive: O(N^2)
	- pass through each element testing to see how long is its max length sub-array
	- record the max length, the starting and finshing index of the current longest sub-array

- better approach, BestCase(2N, for counting and for finding), Worst Case(N^2):
	- Count # of 0s and 1s in the array
	- after counting, start with the max length (i,e: the array's length) and check if sub-array meets the condition, if not, shrink the size of the array being tested
	- if say the number of 0s is less than 1s, then stop testing
		for a longer sub-array if the max. # of 0s is reached.

*/

public class Solution
{
	private static void printSubArrays(int[] array) {
		int numZeroes = 0;
		int numOnes = 0;

		// count # of 0s and 1s
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0)
				numZeroes++;
			else if (array[i] == 1)
				numOnes++;
			else
				throw new IllegalArgumentException("imported array contains values other than 0s and 1s");
		}

		int maxOccurence = Math.min(numZeroes, numOnes);
				
		int currentLength = array.length;
		int currentNumZeroes = 0;
		int currentNumOnes = 0;
		int startingIndex = 0;
		int finalIndex = 0;

		boolean maxSubsetFound = false;

		// start with the longest possible array then shrink the size of the
		// currentLength of a sub-array is not found
		while (currentLength > 0 && !maxSubsetFound) {
			do {
				for (int i = startingIndex; i < (startingIndex + currentLength); i++) {
					finalIndex = i;
					// no need to keep checking if we reached the max number of occurences for
					// both 0's and 1's
					if (currentNumOnes == maxOccurence && currentNumZeroes == maxOccurence)
						break;
					
					if (array[i] == 0) {
						currentNumZeroes++;
					}
					else
						currentNumOnes++;
				}

				if (currentNumOnes == currentNumZeroes) {
					// printing the first element seperately then checking the # of elements
					// ensures current printing of the sub-array
					System.out.print("{" + array[startingIndex]);
					if (currentLength != 1)
						for (int i = startingIndex + 1; i < finalIndex; i++)
							System.out.print("," + array[i]);
					System.out.println("}");

					maxSubsetFound = true;
				}

				currentNumOnes = currentNumZeroes = 0;
				startingIndex++;
			} while ((startingIndex + currentLength) < array.length && !maxSubsetFound);
			
			currentLength--;
		}

		if (!maxSubsetFound)
			System.out.println("Max Subset that has #0's = #1's was not found");
	}
	
	public static void main(String[] args) {
		int[] array = {0,0,1,0,1,1,0,1,0};
		printSubArrays(array);

		int[] array2 = {0,0,1,0,1,0,0};
		printSubArrays(array2);
	}
}