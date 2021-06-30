import java.util.*;
class Solution{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            Stack<Character> stack = new Stack<Character>();

            boolean isBalanced = true;

            int i = 0;
            while (isBalanced && i < input.length()) {
                char ch = input.charAt(i);

                if (ch == '(' || ch == '{' || ch == '[')
                    stack.push(ch);
                else {
                    if (stack.isEmpty())
                        isBalanced = false;
                    else {
                        if (stack.peek() == '(' && ch == ')')
                            stack.pop();
                        else if (stack.peek() == '{' && ch == '}')
                            stack.pop();
                        else if (stack.peek() == '[' && ch == ']')
                            stack.pop();
                        else
                            isBalanced = false;
                    }
                }

                i++;
            }

            if (!stack.isEmpty())
                isBalanced = false;

            // test
            // System.out.println(i);

            System.out.println(isBalanced ? "true" : "false");;
		}
		
	}
}