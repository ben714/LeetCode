import java.util.Arrays;
import java.util.Scanner;

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
