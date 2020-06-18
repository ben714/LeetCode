import java.util.Random;

/* LeetCode Question 4: Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * */

public class Question004 {
    public static void main(String[] args){
        int n = 5;
        int m = 5;
        int[] nums1 = new int[n];
        int[] nums2 = new int[m];
        Random ran = new Random();
        for(int i=0;i<n;i++)
        {

            nums1[i] = (i==0)? ran.nextInt(10):nums1[i-1]+ran.nextInt(10);
            System.out.print(nums1[i]+" ");
        }
        System.out.println(" ");
        for(int i=0;i<m;i++)
        {
            nums2[i] = (i==0)? ran.nextInt(10):nums2[i-1]+ran.nextInt(10);
            System.out.print(nums2[i]+" ");
        }
        System.out.println(" ");
        Question004 obj = new Question004();
        double re = obj.findMedianSortedArrays(nums1,nums2);
        System.out.println(re);

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        /*Method 1: Combine two arrays to one sorted array, and find the Median */
        /*
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len3 = (len1+len2)/2;
        double med;
        int[] arr = new int[len3+1];

        for(int i=0,in1=0,in2=0;i<=len3;i++)
        {
            if(in1<len1 && in2<len2)
            {
                arr[i] =(nums1[in1]<nums2[in2])?nums1[in1++]:nums2[in2++];
            }
            else if(in1<len1){
                arr[i] = nums1[in1++];
            }else{
                arr[i] = nums2[in2++];
            }
        }

        med = ((len1+len2)%2==0)?((double)arr[len3-1]+(double)arr[len3])/2:arr[len3];
        */

        /* Method 2:  Recursive Approach**/
        int len1 = nums1.length;
        int len2 = nums2.length;
        boolean odd = (len1+len2)%2==1;
        if(len1>len2){
            int[] temp = nums1; nums1=nums2; nums2=temp;
            int tem=len1; len1=len2; len2=tem;
        }
        int iMin = 0, iMax = len1, halfLen = (len1 + len2 + 1) / 2;
        double med = 0;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i<iMax && nums1[i] < nums2[j - 1]) {
                iMin = i+1;
            } else if (i>iMin && nums1[i - 1] > nums2[j]) {
                iMax = i-1;
            } else {
                int maxLeft=0;
                if(i==0) {maxLeft=nums2[j-1];}
                else if (j==0) {maxLeft=nums1[i-1];}
                else{maxLeft=Math.max(nums1[i-1],nums2[j-1]);}
                if(odd) {return maxLeft;}

                int minRight=0;
                if(i==len1){minRight=nums2[j];}
                else if(j==len2){minRight=nums1[i];}
                else {minRight=Math.min(nums1[i],nums2[j]);}

                return (maxLeft+minRight)/2.0;
            }
        }
        throw new IllegalArgumentException("No Median");
    }
}
