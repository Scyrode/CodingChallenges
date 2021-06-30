import java.util.Scanner;
import java.util.regex.*;

public class Solution
{
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean result;
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String pattern = in.nextLine();
            try {
                Pattern patternObj = Pattern.compile(pattern);
                result = true;
            } catch (PatternSyntaxException e) {
                result = false;
            }

            System.out.println(result ? "Valid" : "Invalid");
            testCases--;
		}
	}
}