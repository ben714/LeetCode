/* LeetCode Question 22: Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 *  ]
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Question022 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Question022 obj = new Question022();
        List<String> ans = obj.generateParenthesis2(n);
        for(String s:ans){
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n){
        if(n==1){return Arrays.asList("()");}
        List<String> ans = generateParenthesis(n-1);
        List<String> res = new ArrayList<>();
        boolean flag = false;
        for(String s:ans){
            res.add("()"+s);
            if(flag){
                res.add(s+"()");
            }
            res.add("("+s+")");
            flag=true;
        }
        return res;
    }

    //Approach 1: Brute Force
    public List<String> generateParenthesis1(int n){
        List<String> ans = new ArrayList<>();
        generateAll(new char[2*n],0,ans);
        return ans;
    }

    public void generateAll(char[] current, int pos, List<String> result){
        if(pos==current.length){
            if(valid(current)){
                result.add(new String(current));
            }
        }else{
            current[pos]='(';
            generateAll(current,pos+1,result);
            current[pos]=')';
            generateAll(current,pos+1,result);
        }
    }

    public boolean valid(char[] current){
        int balance=0;
        for(char c:current){
            if(c=='('){balance++;}
            else {balance--;}
            if(balance<0){return false;}
        }
        return (balance==0);
    }

    //Approach 2: Backtracking
    public List<String> generateParenthesis2(int n){
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if(cur.length()==2*max){
            ans.add(cur);
            return;
        }
        if(open<max){
            backtrack(ans,cur+'(', open+1, close, max);
        }
        if(close<open){
            backtrack(ans, cur+')',open,close+1, max);
        }
    }

    //Approach 3: Closure Number
    public List<String> generateParenthesis3(int n){
        List<String> ans = new ArrayList<>();
        if(n==0){
            ans.add("");
            return ans;
        }else{
            for(int i=0;i<n;i++)
                for(String left:generateParenthesis3(i))
                    for(String right:generateParenthesis3(n-1-i))
                        ans.add('('+left+')'+right);
        }
        return ans;
    }
}
