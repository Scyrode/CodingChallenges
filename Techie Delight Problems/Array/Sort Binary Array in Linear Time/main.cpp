#include <iostream>
#include <stdio.h>

int main()
{

    int array[] = {0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0};

    int arrayLength = sizeof(array) / sizeof(int);

    int j = 0;
    int swap;

    for (int i = 0; i < arrayLength; ++i)
    {
        if (array[i] == 0)
        {
            swap = array[i];
            array[i] = array[j];
            array[j] = swap;
            j++;
        }
    }

    for (int i = 0; i < arrayLength; ++i)
    {
        std::cout << array[i];
    }

    std::cout << std::endl;
    
}