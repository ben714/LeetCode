/* LeetCode Question 16: 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Constraints:
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * */

import java.util.Arrays;
import java.util.Scanner;

public class Question016 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Length of nums array:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Nums array:");
        for(int i=0;i<n;i++){nums[i]=sc.nextInt();}
        System.out.println("Target:");
        int target = sc.nextInt();
        Question016 obj = new Question016();
        System.out.println("Result:"+obj.threeSumClosest1(nums,target));
    }

    //Approach 1: Two pointer
    public int threeSumClosest(int[] nums, int target){
        int len = nums.length;
        if(len<3) {throw new IllegalArgumentException("The length of array is less than 3.");}
        int diff=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int first=0; first<len;first++){
            if(first>0 && nums[first]==nums[first-1]){continue;}
            int second = first +1;
            int third = len-1;
            while(second<third){
                if(second>first+1 && nums[second]==nums[second-1]){second++;continue;}
                if(third<len-1 && nums[third]==nums[third+1]){third--;continue;}
                int su = (nums[first]+nums[second]+nums[third]);
                if((target-su)==0){return target;}
                if(Math.abs(target-su)<Math.abs(diff)){
                    diff=target-su;
                }
                if(su<target){
                    second++;
                }else{
                    third--;
                }
            }
        }
        return target-diff;
    }
    //Approach 2: Improved Two Pointers
    public int threeSumClosest1(int[] nums, int target){
        Arrays.sort(nums);
        int ans = Integer.MIN_VALUE;
        int minGap = Integer.MAX_VALUE;
        int bigTwo = nums[nums.length-1]+nums[nums.length-2];
        for(int i=0; i<nums.length-2;i++){
            if(nums[i]+nums[i+1]+nums[i+2]-target>minGap){break;}
            if(i<nums.length-3 && nums[i+1]+bigTwo<target){continue;}
            int left = i+1;
            int right = nums.length -1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                int gap = Math.abs(target-sum);
                if(gap==0){return sum;}
                if(gap<minGap){
                    minGap=gap;
                    ans=sum;
                }
                if(sum<target){
                    left++;
                } else{
                    right--;
                }
            }
        }
        return ans;
    }

    //Approach 3: Binary search
    public int threeSumClosest2(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, sz = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < sz && diff != 0; ++i) {
            for (int j = i + 1; j < sz - 1; ++j) {
                int complement = target - nums[i] - nums[j];
                var idx = Arrays.binarySearch(nums, j + 1, sz - 1, complement);
                int hi = idx >= 0 ? idx : ~idx, lo = hi - 1;
                if (hi < sz && Math.abs(complement - nums[hi]) < Math.abs(diff))
                    diff = complement - nums[hi];
                if (lo > j && Math.abs(complement - nums[lo]) < Math.abs(diff))
                    diff = complement - nums[lo];
            }
        }
        return target - diff;
    }

}
