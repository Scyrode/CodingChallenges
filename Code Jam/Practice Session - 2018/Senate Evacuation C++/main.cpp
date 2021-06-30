#include <iostream>

int findBiggestIndex(int *i_parties_ptr, int length);
int findSecondBiggestIndex(int *i_parties_ptr, int length, int i_biggest_index);
int findBiggestSize(int *i_parties_ptr, int length, int i_biggest_index);

int main()
{

    int i_num_test_cases;
    std::cin >> i_num_test_cases;

    for (int i = 0; i < i_num_test_cases; i++)
    {

        int i_num_parties;
        std::cin >> i_num_parties;

        int *i_parties_ptr = new int[i_num_parties];

        for (int j = 0; j < i_num_parties; ++j)
        {
            std::cin >> i_parties_ptr[j];   
        }

        std::cout << "Case #" << (i + 1) << ": ";

        while (true)
        {

            int i_biggest_index = findBiggestIndex(i_parties_ptr, i_num_parties);
            int i_second_biggest_index = findSecondBiggestIndex(i_parties_ptr, i_num_parties, i_biggest_index);
            int i_num_occurences = findBiggestSize(i_parties_ptr, i_num_parties, i_biggest_index);

            if (i_parties_ptr[i_biggest_index] == 0)
            {
                break;
            } else if (i_parties_ptr[i_biggest_index] == 1 && i_num_occurences > 2)
            {
                printf(" %c", (char) 'A' + i_biggest_index);
                i_parties_ptr[i_biggest_index]--;
            } else if (i_parties_ptr[i_biggest_index] == i_parties_ptr[i_second_biggest_index] && i_num_occurences == 2)
            {

                printf(" %c%c", (char) 'A' + i_biggest_index, (char) 'A' + i_second_biggest_index);
                i_parties_ptr[i_biggest_index]--;
                i_parties_ptr[i_second_biggest_index]--;
                
            } else
            {
                printf(" %c%c", (char) 'A' + i_biggest_index, (char) 'A' + i_biggest_index);
                i_parties_ptr[i_biggest_index] -= 2;
            }
            
        }

        std::cout << std::endl;
        
    }

    return 0;
    
}

int findBiggestIndex(int *i_parties_ptr, int length)
{

    int i_biggest_index = 0;

    for (int i = 0; i < length; i++)
    {
        if (i_parties_ptr[i_biggest_index] < i_parties_ptr[i])
        {
            i_biggest_index = i;
        }
    }

    return i_biggest_index;
    
}

int findSecondBiggestIndex(int *i_parties_ptr, int length, int i_biggest_index)
{

    int i_second_biggest_index;

    if (i_biggest_index == 0)
    {
        i_second_biggest_index = 1;
    } else
    {
        i_second_biggest_index = 0;
    }
    
    for (int i = 0; i < length; i++)
    {
        if (i != i_biggest_index)
        {
            if (i_parties_ptr[i_second_biggest_index] < i_parties_ptr[i])
            {
                i_second_biggest_index = i;
            }
        }
    }

    return i_second_biggest_index;
    
}

int findBiggestSize(int *i_parties_ptr, int length, int i_biggest_index)
{

    int i_num_occurrences = 0;

    for (int i = 0; i < length; i++)
    {
        if (i_parties_ptr[i] == i_parties_ptr[i_biggest_index])
        {
            i_num_occurrences++;
        }
    }

    return i_num_occurrences;
    
}