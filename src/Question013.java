/* LeetCode Question 13: Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII,
 * which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 4:
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 * Example 5:
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * */

import java.util.HashMap;
import java.util.Scanner;

public class Question013 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Question013 obj = new Question013();
        System.out.println(obj.romanToInt1(s));
    }

    String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    public int romanToInt(String s){
        int num=0;
        int index=0;
        int i=0;
        while(i<s.length() && index<values.length){
            int len = str[index].length();
            if(len>s.length()-i){index++;continue;}
            if(str[index].equals(s.substring(i,i+len))){
                i+=len;
                num+=values[index];
            }else{
                index++;
            }
        }
        return num;
    }

    public int romanToInt1(String s){
        char[] c = s.toCharArray();
        int num=0;

        for(int i=0; i<c.length;i++)
        {
            switch (c[i]){
                case 'M':
                    num+=1000;
                    break;
                case 'D':
                    num+=500;
                    break;
                case 'C':
                    if(i+1<c.length && (c[i+1]=='M' || c[i+1]=='D')) {num-=100;}
                    else {num+=100;}
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'X':
                    if(i+1<c.length && (c[i+1]=='C' || c[i+1]=='L')) {num-=10;}
                    else {num+=10;}
                    break;
                case 'V':
                    num +=5;
                    break;
                case 'I':
                    if(i+1<c.length && (c[i+1]=='X' || c[i+1]=='V')) {num-=1;}
                    else {num+=1;}
                    break;
            }
        }
        return num;
    }
}
