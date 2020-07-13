/* LeetCode Question 15: 3Sum
 * https://leetcode.com/problems/3sum/
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *  [-1, 0, 1],
 *  [-1, -1, 2]
 * ]
 *
 * */

import java.util.*;

public class Question015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Question015 obj = new Question015();
        List<List<Integer>> re = obj.threeSum(nums);
        for(List<Integer> li:re){
            for(int value:li){
                System.out.print(value+" ");
            }
            System.out.println("");
        }
    }

    //Approach 1
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> re = new ArrayList<>();
        if(nums==null || nums.length<3) {return re;}
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for(int i=2;i<nums.length;i++)
        {
            set.addAll(twoSum(nums,i));
        }
        re = new ArrayList<>(set);
        return re;
    }

    public Set<List<Integer>> twoSum(int[] nums, int index){
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for(int i=0; i<index;i++){
            if(map.containsKey(-nums[index]-nums[i])){
                List<Integer> tmp = new ArrayList<>();
                int lo = map.get(-nums[index]-nums[i]);
                if(lo>i) {
                    tmp.add(nums[i]);
                    tmp.add(nums[lo]);
                }else{
                    tmp.add(nums[i]);
                    tmp.add(nums[lo]);
                }
                tmp.add(nums[index]);
                Collections.sort(tmp);
                set.add(tmp);
            }else
            {
                map.put(nums[i],i);
            }
        }
        return set;
    }
    //Approach 2
    public List<List<Integer>> threeSum1(int[] nums){
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 3) {return ans;}
        Arrays.sort(nums);
        for(int first = 0; first <n; first++){
            if(nums[first]>0){break;}
            if(first >0 && nums[first]==nums[first -1]) {continue;}
            int third = n-1;
            for(int second=first+1;second<n;second++){
                if(second>first+1 && nums[second]==nums[second-1]){continue;}
                while(second<third && nums[first]+nums[second]+nums[third]>0){third--;}
                if(second==third){break;}
                if(nums[first]+nums[second]+nums[third]==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    //Approach 3
    public List<List<Integer>> threeSum2(int[] nums){
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length<3) {return ans;}
        Arrays.sort(nums);
        for(int first=0; first<n;first++){
            if(nums[first]>0){break;}
            if(first>0 && nums[first]==nums[first-1]){continue;}
            int second = first+1;
            int third =  n-1;
            while(second<third){
                int sum = nums[first]+nums[second]+nums[third];
                if(sum==0){
                    ans.add(Arrays.asList(nums[first],nums[second],nums[third]));
                    while(second<third && nums[second]==nums[second+1]){second++;}
                    while(second<third && nums[third]==nums[third-1]){third--;}
                    second++;
                    third--;
                }else if(sum<0){
                    second++;
                }else if(sum>0){
                    third--;
                }
            }
        }
        return ans;
    }
}
