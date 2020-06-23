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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question008 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Question008 obj = new Question008();
        System.out.println("String to Integer: "+obj.myAtoi1(str));
    }

    public int myAtoi(String str)
    {
        int re=0;
        int len = str.length();
        boolean flag = true;
        int limit = Integer.MAX_VALUE/10;
        int index=0;
        //remove spaces
        while(index<len && str.charAt(index)==' ') {index++;}

        if(index==len){return 0;}

        if(str.charAt(index)=='-') {flag=false;index++;}
        else if(str.charAt(index)=='+') {index++;}
        //Positive num boundary: 2147483647
        //Negative num boundary:-2147483648
        int digitlimit = flag?7:8;
        //Get all digits, return when reach boundary
        while(index<len && Character.isDigit(str.charAt(index)))
        {
            int digit = str.charAt(index) - '0';
            if (re>limit || (re==limit && (digit)>digitlimit)) {return flag?Integer.MAX_VALUE:Integer.MIN_VALUE;}
            re=re*10+digit;
            index++;
        }
        return flag?re:-re;
    }

    //Regular expression
    public int myAtoi1(String str) {
        Pattern pattern = Pattern.compile("[-+]??[0-9]+");
        String strTrim = str.trim();
        Matcher matcher = pattern.matcher(strTrim);
        if (matcher.lookingAt()) {
            String strNum = strTrim.substring(0, matcher.end());
            // 如果直接转32位int出现NFE那么就只要判断是Integer的最大值还是最小值就好了
            try {
                return Integer.parseInt(strNum);
            } catch (NumberFormatException nfe) {
                return strNum.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return 0;
    }
}
