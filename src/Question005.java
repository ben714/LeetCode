import java.util.*;

/* LeetCode Question 5: Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * */

public class Question005 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s =sc.nextLine();
        Question005 obj = new Question005();
//        System.out.println("Longest Palindromic Substring:"+obj.longestPalindrome(s));
        System.out.println("Longest Palindromic Substring:"+obj.App4(s));
    }

    public String longestPalindrome(String s){
        int maxIndex = s.length()-1;
        int maxlen=0;
        String re = "";
        if(s.length()>0) {maxlen=1; re=s.substring(0,1);}
        for(int i=0; i<maxIndex; i++)
        {

            int temlen=0;
            if(i>=1 && s.charAt(i-1)==s.charAt(i+1))
            {
                int pl=(i<(maxIndex-i))?i:(maxIndex-i);
                temlen=1;
                for(int j=2; j<=pl; j++)
                {
                    if(s.charAt(i-j)==s.charAt(i+j))
                    {temlen=j;continue;}
                    else {break;}
                }
                if((temlen*2+1)>maxlen)
                {
                    maxlen=(temlen*2+1);
                    re = s.substring(i-temlen,i+temlen+1);
                }

            }
            if(s.charAt(i)==s.charAt(i+1))
            {
                temlen=0;
                int pl=(i<(maxIndex-i-1))?i:(maxIndex-i-1);
                for(int j=1;j<=pl;j++)
                {
                    if(s.charAt(i-j)==s.charAt(i+1+j))
                    {temlen=j;continue;}
                    else {break;}
                }
                if((temlen*2+2)>maxlen)
                {
                    maxlen=(temlen*2+2);
                    re = s.substring(i-temlen,i+2+temlen);
                }
            }
        }
        return re;
    }

    public String App4(String s) {
        if(s==null || s.length()<1) return "";
        int left=0, right=0, len=0;
        for(int i=0; i<(s.length()-len/2); i++)
        {
            int len1=expandAroundCenter(s,i,i);
            int len2=expandAroundCenter(s,i,i+1);
            len=Math.max(len1,len2);
            if((right-left+1)<len){
                left = i - (len-1)/2;
                right = i + len/2;
            }
        }
        return s.substring(left,right+1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
           left--;
           right++;
        }
        return right-left-1;
    }
}
