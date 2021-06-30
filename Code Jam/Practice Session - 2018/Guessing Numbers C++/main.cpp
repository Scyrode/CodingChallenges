/*
mistakes:
    dont include libraries that you dont need
    camel cases are not used in c++ (?) use (_) instead
    use ++i instead i++ (?)
    according to the problem, the equality at the lower end is not inclusive, therefore must increment lowerLimit by 1
    use while loops (and break statement) (similar to Go's for loop) instead of small function
    must change the value of "guess" when re-inserting it into the function (guess + 1) or (guess - 1)
 */

#include <cstdlib>
#include <iostream>
#include <string>
#include <vector>
#include <sstream>

void findGuess(int lowerLimit, int higherLimit);

int main()
{

    int numtestCases, lowerLimit, higherLimit, numTries;

    std::cin >> numtestCases;
    
    for (int i = 0; i < numtestCases; i++)
    {

        std::cin >> lowerLimit >> higherLimit;
        std::cin >> numTries;

        findGuess(lowerLimit + 1, higherLimit);
        
    }

    return 0;
    
}

void findGuess(int lowerLimit, int higherLimit)
{

    int guess = (lowerLimit + higherLimit) / 2;
    std::string result;

    std::cout << guess << std::endl;
    std::cin >> result;

    if (result == "CORRECT")
    {
        return;
    } else if (result == "TOO_SMALL")
    {
        findGuess(guess + 1, higherLimit);
    } else
    {
        findGuess(lowerLimit, guess - 1);
    }

}
