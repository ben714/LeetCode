/* LeetCode Question 14: Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Note:
 * All given inputs are in lowercase letters a-z.
 * */

import java.util.Scanner;

public class Question014 {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] strs = new String[num];
        sc.nextLine();
        for(int i=0;i<num;i++)
        {
            strs[i] = sc.nextLine();
        }
        Question014 obj = new Question014();
        System.out.println(obj.longestCommonPrefix1(strs));
    }

    //Approach 1: Vertical scanning
    public String longestCommonPrefix(String[] strs){
        if(strs==null || strs.length==0) {return "";}
        for(int i=0;i<strs[0].length();i++){
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length() || strs[j-1].charAt(i)!=strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
    //Approach 2: Horizontal scanning
    public String longestCommonPrefix1(String[] strs) {
        if(strs==null || strs.length==0) {return "";}
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    //Approach 3: Divide and conquer
    public String longestCommonPrefix2(String[] strs){
        if(strs==null || strs.length==0) {return "";}
        return longestCommonPrefix(strs,0, strs.length-1);
    }

    public String longestCommonPrefix(String[] strs, int l, int r){
        if(l==r) {
            return strs[l];
        }else{
            int mid = (l+r)/2;
            String lcpLeft = longestCommonPrefix(strs,l,mid);
            String lcpRight = longestCommonPrefix(strs,mid+1,r);
            return commonPrefix(lcpLeft,lcpRight);
        }

    }

    public String commonPrefix(String left, String right){
        int min = Math.min(left.length(), right.length());
        for(int i=0; i<min;i++){
             if(left.charAt(i)!=right.charAt(i)){
                 return left.substring(0,i);
             }
        }
        return left.substring(0,min);
    }

    //Approach 4: Binary search
    public String longestCommonPrefix4(String[] strs){
        if(strs==null || strs.length==0){return "";}
        int minlen = Integer.MAX_VALUE;
        for(String str:strs){
            minlen = Math.min(minlen,str.length());
        }
        int low=1;
        int high=minlen;
        while(low<=high){
            int mid = (low+high)/2;
            if(iscommonPrefix(strs,mid)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return strs[0].substring(0,(low+high)/2);
    }

    public boolean iscommonPrefix(String[] strs, int len){
        String str0 = strs[0].substring(0,len);
        for(int i=0;i<strs.length;i++){
            if(!strs[i].startsWith(str0)){return false;}
        }
        return true;
    }
}
