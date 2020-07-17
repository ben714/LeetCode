/* LeetCode Question 20: Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 *  1.Open brackets must be closed by the same type of brackets.
 *  2.Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 * Input: "{[]}"
 * Output: true
 * */

import java.util.*;

public class Question020 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Question020 obj = new Question020();
        System.out.println(obj.isValid1(s));

    }

    //Approach 1: Stack
    public boolean isValid(String s){
        int len = s.length();
        Stack<Character> st = new Stack<>();
        st.push('*'); //Dummy value '*'
        if(len%2!=0){
            return false;
        } else{
            for(int i=0;i<len;i++)
            {
                char c = s.charAt(i);
                if(notMatch(st.peek(),c)){
                    st.push(c);
                }else{
                    st.pop();
                }
            }
            st.pop();
        }
        return st.empty();
    }
    public boolean notMatch(char l, char r){
        if(l=='('){
            if(r==')'){return false;}
        }else if(l=='[') {
            if(r==']'){return false;}
        }else if(l=='{'){
            if(r=='}'){return false;}
        }
        return true;
    }

    //Approach 2: Stack (Using HashMap)
    private static final Map<Character,Character> map = new HashMap<Character, Character>(){
        {put('(',')');put('[',']');put('{','}');}
    };

    public boolean isValid1(String s){
        if(s.length()%2!=0) return false;
        Stack<Character> stack = new Stack<Character>();
        stack.push('*');
        for(Character c:s.toCharArray()){
            if(map.containsKey(c)) stack.push(c);
            else if(map.get(stack.pop())!=c) return false;
        }
        stack.pop();
        return stack.empty();
    }

}
