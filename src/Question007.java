/* LeetCode Question 7: Reverse Integer
 * https://leetcode.com/problems/reverse-integer/
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * */

import java.util.*;

public class Question007 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Question007 obj = new Question007();
        System.out.println("The reverse of the num: "+obj.reverse(num));
    }

    public int reverse(int x)
    {
        int re=0;
        int left = Integer.MIN_VALUE/10;
        int right = Integer.MAX_VALUE/10;
        while (x!=0)
        {
            if(re<left || re > right) return 0;
            re=re*10+(x%10);
            x=x/10;
        }
        return re;
    }
}
