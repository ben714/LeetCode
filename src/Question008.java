/* LeetCode Question 8: String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/
 * Implement atoi which converts a string to an integer.
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned.
 * Note:
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * If the numerical value is out of the range of representable values, INT_MAX (2^31 − 1) or INT_MIN (−2^31) is returned.
 * Example 1:
 * Input: "42"
 * Output: 42
 *
 * Example 2:
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 *
 * Example 3:
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 *
 * Example 4:
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical digit or a +/- sign.
 * Therefore no valid conversion could be performed.
 *
 * Example 5:
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 * */

import java.util.Scanner;

public class Question008 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Question008 obj = new Question008();
        System.out.println("String to Integer: "+obj.myAtoi(str));
    }

    public int myAtoi(String str)
    {
        int re=0;
        int len = str.length();
        boolean flag = true;
        boolean check = false;
        int left = Integer.MIN_VALUE/10;
        int right = Integer.MAX_VALUE/10;
        for(int i=0; i<len;i++)
        {
            int as = (int) str.charAt(i);

            if(as>47 && as<58)
            {
                check=true;
                if (re<left || (re==left && (as-48) >8 ))  {return Integer.MIN_VALUE;}
                if (re>right || (re==right && (as-48)>7)) {return Integer.MAX_VALUE;}
                re=flag?re*10+(as-48):re*10-(as-48);
            } else if(re!=0)
            {
                return re;
            }

            if(re==0)
            {
                if(check&&as!=48) {return re;}
                else if(as==45) {flag=false; check=true;}
                else if(as==43) {check=true;}
                else if(as==32||as==48) {continue;}
                else {return re;}
            }
        }
        return re;
    }
}
