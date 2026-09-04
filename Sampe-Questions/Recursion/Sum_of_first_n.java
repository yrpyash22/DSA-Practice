package Recursion;

public class Sum_of_first_n {

    public static int allSum(int n)
    {
        if(n==1)
        {
            return 1;
        }
        int sum = allSum(n -1 );
        int res = n + sum;
        return res;
    }

    public static void main(String[] args) {
        int n = 15;

        System.out.println("Sum of all value: "+ allSum(n));
    }
}
