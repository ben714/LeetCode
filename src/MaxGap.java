import java.util.Arrays;
import java.util.Scanner;

/* Geeks for geeks Question: Maximum Gap
Given an unsorted array. Your task is to find the maximum difference between the successive elements in its sorted form.

Input:
The first line of input contains an integer T,  number of test cases.
Following T lines contains an integer N denoting the size of array and next line followed contains the array elements.

Output:
Print the maximum gap between the successive elements.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106
1 ≤ A[i] ≤ 106

Example:
Input:
1
3
1 10 5

Output:
5
*/

public class MaxGap {
    public static void main(String[] args)
    {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0)
        {
            int col = sc.nextInt();
            int[] arr = new int[col];
            for(int i=0;i<col;i++)
            {
                arr[i]=sc.nextInt();
            }
            MaxGap obj = new MaxGap();
            System.out.println(obj.MG(arr));
        }
    }

    int MG(int[] arr)
    {
        int len = arr.length;
        int temp;
        int gap = 0;

        Arrays.sort(arr);
        for(int i=0;i<len-1;i++){
            temp = arr[i+1] - arr[i];
            if(temp>gap){gap=temp;}
        }
        return gap;
    }
}
