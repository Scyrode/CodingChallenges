import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int n = in.nextInt();
        int m = in.nextInt();

        int i = 0;
        while (deque.size() < m && i < n) {
            int num = in.nextInt();
            if (deque.contains(num)) {
                deque.removeFirst();
            }

            deque.addLast(num);

            i++;
        }

        System.out.println(deque.size());

        in.close();
    }
}