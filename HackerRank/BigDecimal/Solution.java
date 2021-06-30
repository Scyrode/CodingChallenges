import java.math.BigDecimal;
import java.util.*;
class Solution{
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here
        Map<BigDecimal, String> bigDecimals = new TreeMap<>();

        for (String currentString : s) {
            if (currentString != null) {
                bigDecimals.put(new BigDecimal(currentString), currentString);
            }
        }

        int index = n-1;

        for (Map.Entry<BigDecimal, String> entry : bigDecimals.entrySet()) {
            s[index] = entry.getValue();
            index--;
        }
        
        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}