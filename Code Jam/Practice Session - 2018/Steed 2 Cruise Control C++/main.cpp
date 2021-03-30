/* mistakes:
    - use max function from #algorithm library instead of using if statement
    - check if there is any accuracy restricts in the question and print an answer with a greater
    accuracy than the one required
    - ++i is the convention in c++ (?)
    - mistakes mentioned in Go Solution
 */

#include <iostream>
#include <algorithm>

int main()
{
    int numTestCases;

    std::cin >> numTestCases;

    for (int i = 0; i < numTestCases; i++)
    {

        int destination, numHorses;
        double totalTime = 0.0f;
        std::cin >> destination >> numHorses;

        for (int j = 0; j < numHorses; j++)
        {

            int horseLocation, horseSpeed;
            double horseTime;
            std::cin >> horseLocation >> horseSpeed;

            horseTime = (destination - horseLocation) / double(horseSpeed);

            totalTime = std::max(totalTime, horseTime);
            
        }

        double annieSpeed = (double) destination / totalTime;

        printf("Case #%d: %.9lf\n", i+1, annieSpeed);
        
    }
       
}