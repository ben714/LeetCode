/* LeetCode Question 17: Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * */

import java.util.*;

public class Question017 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        Question017 obj = new Question017();
        List<String> re = obj.letterCombinations1(digits);
        for(String li:re){
                System.out.print(li+" ");
        }
    }

    //Approach 1: Recursive
    public List<String> letterCombinations(String digits){
        if(digits==null||digits.length()<1){return Collections.emptyList();}
        return combine(digits,0);
    }

    HashMap<Character,String> digitMap = new HashMap<Character,String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public HashMap<Integer,List<String>> memo = new HashMap<>();

    public List<String> combine(String digits, int index){
        if(memo.containsKey(index)){return memo.get(index);}
        List<String> ans = new ArrayList<>();
        String str = digitMap.get(digits.charAt(index));
        int len =str.length();
        if(index==digits.length()-1){
            for(int i=0; i<len;i++){
                ans.add(str.substring(i,i+1));
            }
        }else if(index<digits.length()-1){
            List<String> nextList = combine(digits,index+1);
            for(int i=0;i<len;i++) {
                for (String li : nextList) {
                    ans.add(str.substring(i,i+1).concat(li));
                }
            }
        }
        memo.put(index,ans);
        return ans;
    }
    //Approach 2: Backtracking
    public List<String> letterCombinations1(String digits){
        if(digits.length()==0) {return new ArrayList<>();}
        String[] phone = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans = new ArrayList<>();
        letterCombinationsHelper(phone, digits, 0, ans, new StringBuilder());
        return ans;
    }

    private void letterCombinationsHelper(String[] phone, String digits, int idx, List<String> ans, StringBuilder sb){
        if(idx==digits.length()){
            ans.add(sb.toString());
            return;
        }
        String word = phone[digits.charAt(idx)-'0'];
        for(int i=0;i<word.length();i++){
            sb.append(word.charAt(i));
            letterCombinationsHelper(phone,digits,idx+1,ans,sb);
            sb.setLength(sb.length()-1);
        }
    }
}
