/*
things learnt:
    - vectors are used for dynamic growth or shrinking. can access tis elements using stack methods and also using indexes
    - unordered_map is basically a HashMap (as far as i understand?). very useful if you want effecient use of memory as compared to the unknown nature of array decleration and whitespaces.
    - foreach loops can be created in c++ in the fashion shown in the code below    
 */

#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

int findMostOccurence(vector<int> vec);

int main()
{

    vector<int> vec = { 2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2 };

    int result = findMostOccurence(vec);

    if (result == -1)
    {
        cout << "Majority Element does not exist" << endl;
    } else
    {
        cout << "Majority Element is: " << result << endl;
    }
    
    return 0;

}

int findMostOccurence(vector<int> vec)
{

    unordered_map<int, int> countMap;

    // store the frequency of elements in the map
    for (int i = 0; i < vec.size(); ++i)
    {
        countMap[vec[i]]++;
    }

    int greatestValue = 0;
    int greatestIndex = 0;

    // retrieve a value that has mos toccurence (at least n/2)
    for (auto pair : countMap)
    {
        if (pair.second > (vec.size()/2))
        {
            return pair.first;
        }
    }

    // Note that step 2 and step 3 can be merged into one
	/* for (int i = 0; i < n; i++)
	{
		if (++map[A[i]] > n/2)
			return A[i];
	} */

    // if no majority element exists
    return -1;
    
}