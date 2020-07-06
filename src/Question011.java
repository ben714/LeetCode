/* LeetCode Question 11: Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 *
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * */

import java.util.Scanner;

public class Question011 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] hight = new int[len];
        for(int i=0;i<len;i++){
            hight[i] = sc.nextInt();
        }
        Question011 obj = new Question011();
        System.out.println(obj.maxArea(hight));
    }

    public int maxArea(int[] height){
        int len = height.length;
        int maxA = 0;
        if(len<1){ return maxA;}
        int left=0;
        int right=len-1;
        while(left<right)
        {
            maxA = Math.max(maxA, (right - left) * Math.min(height[left], height[right]) );
            if(height[left]< height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxA;
    }
}
