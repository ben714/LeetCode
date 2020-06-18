/*
Given an array arr[] of size N. The task is to complete partition() function which is used to implement Quick Sort.

Input:
First line of the input denotes number of test cases 'T'. First line of the test case is the size of array and second line consists of array elements.

Output:
For each testcase, in a new line, print the sorted array.

Your Task:
This is a function problem. You only need to complete the function partition(). The printing is done automatically by the driver code.

Constraints:
1 <= T <= 50
1 <= N <= 103
1 <= arr[i] <= 104

Example:
Input:
2
5
4 1 3 9 7
10
10 9 8 7 6 5 4 3 2 1
Output:
1 3 4 7 9
1 2 3 4 5 6 7 8 9 10

Explanation:
Testcase 1: Elements in sorted form are 1 3 4 7 9.
Testcase 2: Elements in sorted form are 1 2 3 4 5 6 7 8 9 10.
 */
import java.util.*;


/* Geeks for geeks Question: Quick Sort
Given an array of integers. Complete the partition() function used for the implementation of Quick Sort.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
The first line of each test case is N, size of the array.
The second line of each test case contains N space separated values of the array arr[].

Output:
For each testcase, in a new line, print the sorted array.

Your Task:
You don't need to read input or print anything.
Your task is to complete the function partition() which takes the array arr[] and the range of indices to be considered [low, high] and partitions the array
in the given range considering the last element as the pivot such that, all the elements less than(or equal to) the pivot lie before the elements greater than it.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 50
1 <= N <= 103
1 <= arr[i] <= 104

Example:
Input:
2
5
4 1 3 9 7
10
10 9 8 7 6 5 4 3 2 1

Output:
1 3 4 7 9
1 2 3 4 5 6 7 8 9 10
*/

public class QuickSort {
    static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }
    int partition(int[] arr, int low, int high)
    {
        int index = low - 1;
        int pivot = arr[high];
        int temp=0;
        for(int i=low; i<= high-1; i++)
        {
            if(arr[i]<pivot)
            {
                index++;
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
        index++;
        temp = arr[index];
        arr[index] = arr[high];
        arr[high] = temp;

        return index;
    }

    static void quickSorting(int[] arr, int low, int high)
    {
        if(low<high)
        {
            int pi = new QuickSort().partition(arr,low,high);
            quickSorting(arr, low, pi-1);
            quickSorting(arr, pi+1, high);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T>0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();

            quickSorting(arr,0,n-1);
            printArray(arr);

            T--;
        }
    }
}
