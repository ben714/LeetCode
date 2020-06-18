import java.util.Scanner;
import java.util.HashMap;

/*  LeetCode Question 1: Two Sum
* https://leetcode.com/problems/two-sum/
* Given an array of integers, return indices of the two numbers such that they add up to
* a specific target.
* You may assume that each input would have exactly one solution,
* and you may not use the same element twice.
*
* Example:
* Given nums = [2, 7, 11, 15], target = 9,
* Because nums[0] + nums[1] = 2 + 7 = 9,
* return [0, 1].
* */

public class Question001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] re = new int[2];
        Question001 obj = new Question001();
        while (T > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            int target = sc.nextInt();
            re = obj.twoSum(arr, target);
            for (int value : re) System.out.print(value + " ");
            T--;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> list = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++)
        {
            if(list.containsKey(target-nums[i]))
            {
                return new int[] {list.get(target-nums[i]),i};
            }
            list.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
