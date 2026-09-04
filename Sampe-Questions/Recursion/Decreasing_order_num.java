package Recursion;

public class Decreasing_order_num {
    
    public static void printDecreasingOrder(int n)
    {
        if(n==1)                                // Base case
        {
            System.out.print(n);
            return;
        }
        System.out.println(n + " ");            // Working 
        printDecreasingOrder(n-1);              // Inner case
    }
    public static void main(String[] args) {
        int n = 15;
        printDecreasingOrder(n);
    }
}
