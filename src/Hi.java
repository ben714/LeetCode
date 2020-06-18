import java.io.*;
import java.util.*;
import java.lang.*;

public class Hi {
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
            Geeks obj = new Geeks();
            System.out.println(obj.MaxGap(arr));
            System.out.println("");
        }
    }
}

class Geeks{
    static int MaxGap(int[] arr)
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
