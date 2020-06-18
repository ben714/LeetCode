//Draft only

public class test1 {
    public static void main(String args[])
    {
        int[] x= new int[3];
        x[0]=1;
        x[1]=2;
        x[2]=3;
        test1 obj = new test1();
        obj.cal(x[0]);

        String firstName = "John ";
        String lastName = "Doe";
        firstName=firstName.substring(1);
        System.out.println(firstName);

    }

    public void cal(int x)
    {
        x=2;

    }
}
