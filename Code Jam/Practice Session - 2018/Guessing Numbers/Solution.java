import java.util.Scanner;

public class Solution
{

    public static void main(String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int currentTestCase = 0;
        boolean isWrongAnswer = false;
        
        int numTestCases = sc.nextInt();
        
        while (currentTestCase < numTestCases && !isWrongAnswer)
        {
            
            int currentTry = 0;
            boolean isCorrectAnswer = false;
            
            int lowerLimit = sc.nextInt();
            int upperLimit = sc.nextInt();
            
            int numTries = sc.nextInt();
            
            // intial guess should the median
            int guess = (lowerLimit + upperLimit) / 2;
            
            while (!isCorrectAnswer && !isWrongAnswer && currentTry < numTries)
            {
                
                System.out.println(guess);
                System.out.flush();
                
                String response = sc.next();
                
                if (response.equals("CORRECT"))
                {
                    isCorrectAnswer = true;
                } else if (response.equals("TOO_SMALL"))
                {
                    
                    lowerLimit = guess;
                    guess = (upperLimit + lowerLimit) / 2;
                    
                } else if (response.equals("TOO_BIG"))
                {
                    
                    upperLimit = guess;
                    guess = (upperLimit + lowerLimit) / 2;
                    
                } else if (response.equals("WRONG_ANSWER"))
                {
                    isWrongAnswer = true;
                }

                currentTry++;
                
            }
            
            currentTestCase++;
            
        }

        sc.close();
        System.exit(0);
        
    }
    
}