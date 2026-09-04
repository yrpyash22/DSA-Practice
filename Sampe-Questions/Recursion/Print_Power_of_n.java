package Recursion;

public class Print_Power_of_n {
    
    public static int pow(int x, int n)
    {
        if(n == 0)
        {
            return 1;
        }
        return x * pow(x, n -1);
    } // O(n)


    public static long pow2(int x, int n)
    {
        if( n == 0)
        {
            return 1;
        }

        long halfPow = pow2(x, n/2);
        long halfPowSquare = halfPow * halfPow;

        if(n % 2 != 0)
        {
            halfPowSquare = x * halfPow;
        }
        return halfPowSquare;
    }   // O(logn)


    public static void main(String[] args) {
        int x = 5,  n = 5;
        int x2 = 50,  n2 = 50;
        System.out.println("Power is : "+ pow(x, n));
        System.out.println("Power is : "+ pow2(x2, n2));
    }
}
