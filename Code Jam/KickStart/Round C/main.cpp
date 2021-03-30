/* Mistakes:
    - Could have used std::map<std::pair<int, int>, bool> vis; instead of 2d array as it is more memrory effecient and it gives you a faster computational time
 */

#include <iostream>

int main()
{
    
    int numTestCases;
    
    std::cin >> numTestCases;
    
    for (int i = 0; i < numTestCases; ++i)
    {

        int numInstructions, rows, columns, currentRow, currentColumn;
        std::cin >> numInstructions >> rows >> columns >> currentRow >> currentColumn;

        char* instructions = new char[numInstructions];
        std::cin >> instructions;

        bool** grid = new bool*[rows];

        for (int j = 0; j < rows; ++j)
        {
            grid[j] = new bool[columns];

            for (int k = 0; k < columns; ++k)
            {
                grid[j][k] = false;
            }
            
        }

        // as we are currently standing on that block
        grid[currentRow][currentColumn] = true;

        for (int j = 0; j < numInstructions; ++j)
        {

            int counter;
            
            switch (instructions[j])
            {

                case 'N':

                counter = currentRow - 1;

                while (true)
                {

                    if (grid[counter][currentColumn] == false)
                    {
                        break;
                    }

                    counter--;
                    
                }

                currentRow = counter;

                grid[currentRow][currentColumn] = true;
                
                break;

                case 'E':

                counter = currentColumn + 1;

                while (true)
                {

                    if (grid[counter][currentColumn] == false)
                    {
                        break;
                    }

                    counter++;
                    
                }

                currentColumn = counter;

                grid[currentRow][currentColumn] = true;
                
                break;

                case 'S':

                counter = currentRow + 1;

                while (true)
                {

                    if (grid[counter][currentColumn] == false)
                    {
                        break;
                    }

                    counter++;
                    
                }

                currentRow = counter;

                grid[currentRow][currentColumn] = true;
            
                break;

                case 'W':

                counter = currentColumn - 1;

                while (true)
                {

                    if (grid[counter][currentColumn] == false)
                    {
                        break;
                    }

                    counter--;
                    
                }

                currentColumn = counter;

                grid[currentRow][currentColumn] = true;
                
                break;
                
                default:
                break;
            }
        }

        std::cout << "Case #" << (i+1) << ": " << currentRow << currentColumn;
        
    }
    
}