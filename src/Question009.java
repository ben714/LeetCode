/* LeetCode Question 9: Palindrome Number
 * https://leetcode.com/problems/palindrome-number/
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * Example 1:
 * Input: 121
 * Output: true
 *
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * */

import java.util.Scanner;

public class Question009 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Question009 obj = new Question009();
        System.out.println(obj.isPalindrome(num));
    }

    //Convert to String
    public boolean isPalindrome(int x)
    {
        String num = Integer.toString(x);
        int len = num.length();
        int left=0;
        int right=len-1;
        if (x < 0 || (x % 10 == 0 && x != 0)) return false; // if x!=0, and the last digit is 0, not palindrome
        if (x < 10) return true;
        while(left<=right)
        {
            if(num.charAt(left)!=num.charAt(right)) {break;}
            left++;
            right--;
        }
        return left>right?true:false;
    }

    //Revert the whole number
    public boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        if (x < 10) return true;
        int y = x, result = 0;
        while (y > 0){
            result = result*10 + y % 10;
            y = y/10;
        }
        return result == x;
    }

    //Revert half part of the number, and compare two halves
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

}
