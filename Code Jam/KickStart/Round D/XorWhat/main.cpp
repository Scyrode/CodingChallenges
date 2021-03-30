#include <sstream>
#include <iostream>
#include <map>
#include <string>

bool isEven(int x);

int main()
{

    int numTestCases;
    
    std::cin >> numTestCases;
    
    for (int i = 0; i < numTestCases; ++i)
    {

        int numElements, numModifications;
        std::cin >> numElements >> numModifications;

        std::ostringstream os;
        os << "Case #" << (i+1) << ": ";

        // note: dont forget to delete the array at the end
        int* elementsArray = new int[numElements];

        for (int j = 0; j < numElements; ++j)
        {
            std::cin >> elementsArray[j];
        }

        int indexOfValue = numElements;

        std::map<std::pair<int, int>, int> storedXorSums;

        recursiveCalcXorSums(0, numElements - 1, storedXorSums, elementsArray);

        for (int j = 0; j < numModifications; ++j)
        {

            int modifiedValue;
            indexOfValue = 0;
            std::cin >> indexOfValue >> modifiedValue;

            elementsArray[indexOfValue] = modifiedValue;

            if (indexOfValue < (numElements - 1))
            {
                for (int j = indexOfValue + 1; j < numElements; ++j)
                {
                    storedXorSums[{elementsArray[j-1], elementsArray[j]}] = elementsArray[j-1] ^ elementsArray[j];
                }
            }

            int sizeOfSubInterval = numElements;

            int firstPointer = 0, secondPointer = sizeOfSubInterval - 1;

            int xorSum = 0;

            while (true)
            {

                xorSum = storedXorSums[{firstPointer,secondPointer}];

                // test
                std::cout << xorSum << std::endl;

                if (isEven(xorSum))
                {
                    break;
                }

                if (secondPointer == (numElements - 1) && sizeOfSubInterval > 1)
                {
                    sizeOfSubInterval--;
                    firstPointer = 0;
                    secondPointer = sizeOfSubInterval - 1;
                } else
                {
                    firstPointer++;
                    secondPointer++;
                }
                
            }

            os << sizeOfSubInterval << " ";
            
        }

        os << std::endl;
        std::string output = os.str();

        std::cout << output;

    }
       
}

bool isEven(int x)
{
    
    int counter = 0;

    for (int i = x; i > 0; ++i)
    {
        if ((i % 2) == 1)
        {
            counter++;
        }
    }

    if ((counter % 2) == 0)
    {
        return true;
    } else
    {
        return false;
    }
    
}

int recursiveCalcXorSums(int firstIndex, int secondIndex, std::map<std::pair<int, int>, int> storedXorSums, int* elementsArray)
{

    if ((secondIndex - firstIndex) == 1)
    {
        if ()
    }
    
}