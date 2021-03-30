import java.util.Arrays;

public class Test
{
    public static void main(String[] args) {
        int[] array = {3,-3,3,2,-5,0,-1,1};

        Solution solution = new Solution();

        int[][] result = solution.findSubTermsAddToZero(array);

        for (int i = 0; i < 10; i++)
            System.out.println(Arrays.toString(result[i]));
    }
}