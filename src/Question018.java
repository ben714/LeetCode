/* LeetCode Question 18: 4Sum
 * https://leetcode.com/problems/4sum/
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 *      [-1,  0, 0, 1],
 *      [-2, -1, 1, 2],
 *      [-2,  0, 0, 2]
 * ]
 * */

import java.util.*;

public class Question018 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Length of nums array:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Nums array:");
        for(int i=0;i<n;i++){nums[i]=sc.nextInt();}
        System.out.println("Target:");
        int target = sc.nextInt();
        Question018 obj = new Question018();
        System.out.println("Result:"+obj.fourSum2(nums,target));
    }
    //Approach 1: Two Pointers
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(len<4) {return ans;}
        Arrays.sort(nums);
        int bigTwo = nums[len-1]+nums[len-2];
        int bigThree = bigTwo+nums[len-3];
        for(int first=0; first<len-3;first++){
            if(first>0 && nums[first]==nums[first-1]) {continue;}
            if(nums[first]+bigThree<target){continue;}
            if(nums[first]+nums[first+1]+nums[first+2]+nums[first+3]>target){break;}
            for(int second=first+1; second<len-2;second++){
                if(second>first+1 && nums[second]==nums[second-1]){continue;}
                if(nums[first]+nums[second]+bigTwo<target){continue;}
                if(nums[first]+nums[second]+nums[second+1]+nums[second+2]>target){break;}
                int third = second+1;
                int fourth = len-1;
                while(third<fourth) {
                    if(nums[first]+nums[second]+bigTwo<target){break;}
                    int sum = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (sum < target) {
                        third++;
                    } else if (sum > target) {
                        fourth--;
                    } else {
                        ans.add(Arrays.asList(nums[first],nums[second],nums[third],nums[fourth]));
                        while(third<fourth && nums[third]==nums[third+1]){third++;}
                        while(third<fourth && nums[fourth]==nums[fourth-1]){fourth--;}
                        third++;
                        fourth--;
                    }
                }
            }
        }
        return ans;
    }

    //Approach 2: Two Pointers (KSum solution)
    public List<List<Integer>> fourSum1(int[] nums, int target){
        Arrays.sort(nums);
        return kSum(nums,target,0,4);
    }

    public List<List<Integer>> kSum(int[] nums, int target, int start, int k){
        List<List<Integer>> ans = new ArrayList<>();
        if(start==nums.length || nums[start]*k>target || nums[nums.length-1]*k<target){return ans;}
        if(k==2) return twoSum(nums,target,start);
        for(int i=start; i<nums.length-k+1;i++){
            if(i==start || nums[i]!=nums[i-1]){
                for(var set:kSum(nums,target-nums[i],i+1,k-1))
                {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i])));
                    ans.get(ans.size()-1).addAll(set);
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start){
        List<List<Integer>> ans = new ArrayList<>();
        int lo = start, hi = nums.length-1;
        while(lo<hi){
            int sum=nums[lo]+nums[hi];
            if(sum<target ||(lo>start && nums[lo]==nums[lo-1])){
                lo++;
            }else if (sum>target ||(hi< nums.length-1 && nums[hi]==nums[hi+1]))
            {
                hi--;
            }else{
                ans.add(Arrays.asList(nums[lo++],nums[hi--]));
            }
        }
        return ans;
    }

    //Approach 3: Hash Set (kSum Solution)
    public List<List<Integer>> fourSum2(int[] nums, int target){
        Arrays.sort(nums);
        return kSum1(nums,target,0,4);
    }

    public List<List<Integer>> kSum1(int[] nums, int target, int start, int k){
        List<List<Integer>> ans = new ArrayList<>();
        if(start==nums.length || nums[start]*k>target || nums[nums.length-1]*k<target){return ans;}
        if(k==2) return twoSum1(nums,target,start);
        for(int i=start; i<nums.length-k+1;i++){
            if(i==start || nums[i]!=nums[i-1]){
                for(var set:kSum1(nums,target-nums[i],i+1,k-1))
                {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i])));
                    ans.get(ans.size()-1).addAll(set);
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> twoSum1(int[] nums, int target, int start){
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        for(int i=start;i<nums.length;i++){
            if(ans.isEmpty() || nums[i-1]!= nums[i]) {
                //Faster than checking res.get(res.size() - 1).get(1) != nums[i]
                if (s.contains(target - nums[i])) {
                    ans.add(Arrays.asList(target - nums[i], nums[i]));
                }
                s.add(nums[i]);
            }
        }
        return ans;
    }
}
