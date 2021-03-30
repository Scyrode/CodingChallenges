#include <string>
#include <iostream>

int main()
{
    
    char input[100];
    char output[100];
    std::cout << "Enter a word that you would like to get the reverse of: " << std::endl;
    std::cin >> input;

    for (int i = 0; i < 100; i++)
    {
        output[100 - i] = input[i];
    }

    std::cout << output;
        
}