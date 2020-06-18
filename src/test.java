import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args)
    {
        long startTime = System.nanoTime();

        final int[] arr = {37, 23, 0, 17, 12, 72, 31,
                46, 100, 88, 54, 3, 77 ,108, 56, 42 };

//        System.out.println(new test().sort(arr));
        System.out.println(new test().MaxGap(arr));

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
//        System.out.println("Execution time in milliseconds : " + timeElapsed / 1000000);
        System.out.println("Execution time in milliseconds : " + timeElapsed);
    }

    public int MaxGap(int[] arr)
    {
        int len = arr.length;
        int temp = 0;
        int gap = 0;

        for(int i=0; i<len-1; i++)
        {
            for(int j=i+1;j<len;j++)
            {
                if(arr[i]>arr[j])
                {
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }

        for(int i=0; i<len-1; i++)
        {
            if(arr[i+1]-arr[i]>gap) {gap = arr[i+1]-arr[i];}
        }
        return gap;
    }


}
