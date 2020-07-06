/* LeetCode Question 12: Integer to Roman
 * https://leetcode.com/problems/integer-to-roman/
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
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 4:
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 *
 * Example 5:
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * */

import java.util.Scanner;

public class Question012 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Question012 obj = new Question012();
        System.out.println(obj.intToRoman1(num));
    }

    public String intToRoman(int num){
        String re ="";
        char[] Ind = {'I','V','X','L','C','D','M'};

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while(num>0){
            int digit = num%10;
            num = num/10;
            sb.insert(0,toStr(Ind, digit, i));
            i+=2;
        }
        return sb.toString();
    }

    public String toStr(char[] Ind, int digit, int i) {
        StringBuilder str= new StringBuilder("");
        if(digit==4){
            str.append(Ind[i]);
            str.append(Ind[i+1]);
        }else if(digit==9){
            str.append(Ind[i]);
            str.append(Ind[i+2]);
        }else if(digit>=1 && digit<=3){
            for(int j=1;j<=digit;j++) {
                str.append(Ind[i]);
            }
        }else if(digit>=5 && digit<=8){
            str.append(Ind[i+1]);
            for(int j=6;j<=digit;j++) {
                str.append(Ind[i]);
            }
        }
        return str.toString();
    }

    String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    public String intToRoman1(int num){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<values.length && num>0;i++){
            while(num>=values[i]){
                num=num-values[i];
                sb.append(str[i]);
            }
        }
        return sb.toString();
    }


}
