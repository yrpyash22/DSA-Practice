package Recursion;

public class Fibonachi_Sequence {

    public static int fib(int n)
    {
        if(n == 0 || n == 1)
        {
            return n;
        }
        int fib1 = fib(n -1);
        int fib2 = fib(n -2);
        int res = fib1 + fib2;
        return res;
    }
    

    public static void main(String[] args) {
        int n = 6;
        System.out.println("Fibonachi of :"+ n + " is: " + fib(n));
    }
}
