import java.util.*;

/*
* Three way quick sort solution based on the QuickSort
*/

public class ThreeWayQuickSort {

    static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }
    static int[] partition(int[] arr, int low, int high)
    {
        int[] index = new int[2];
         index[0] = low - 1;
         index[1] = 0;
        int pivot = arr[high];
        int temp=0;
        int bound = high -1;
        for(int i=low; i<= bound; i++)
        {
            if(arr[i]==pivot)
            {
                while(arr[bound]==pivot && i<bound){
                    bound--;
                    index[1]++;
                }
                temp = arr[bound];
                arr[bound] = arr[i];
                arr[i] = temp;
                bound--;
                index[1]++;
            }

            if(arr[i]<pivot)
            {
                index[0]++;
                temp = arr[index[0]];
                arr[index[0]] = arr[i];
                arr[i] = temp;
            }
        }
        index[0]++;
        for(int i=0; i<=index[1]; i++) {
            temp = arr[index[0]+i];
            arr[index[0]+i] = arr[high-i];
            arr[high-i] = temp;
        }

        return index;
    }

    static void quickSorting(int[] arr, int low, int high)
    {
        if(low<high)
        {
            int[] pi = partition(arr,low,high);
            quickSorting(arr, low, pi[0]-1);
            quickSorting(arr, pi[0]+pi[1]+1, high);
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

            long startTime = System.currentTimeMillis();

            quickSorting(arr,0,n-1);
            printArray(arr);

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(elapsedTime);

            T--;
        }
    }
}
