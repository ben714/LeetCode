import java.util.*;

/*  LeetCode Question 3: Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * */

public class Question003 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Question003 obj = new Question003();
        int len = obj.LengthofLongestSubstring(s);
        System.out.println("Length of Longest Substring:"+len);
    }

    public int LengthofLongestSubstring(String s){
        /*
        //Sliding Window Optimized
        int len = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0,j=0; i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {j = Math.max(map.get(s.charAt(i))+1,j);}
            len = Math.max(i-j+1,len);
            map.put(s.charAt(i),i);
        }
         */
        //(Assuming ASCII 128)
        int len = 0;
        int[] index = new int[128];
        for(int i=0, j=0; i<s.length();i++)
        {
            j = Math.max(index[s.charAt(i)],j);
            len = Math.max(i-j+1, len);
            index[s.charAt(i)]=i+1;
        }
        return len;
    }
}