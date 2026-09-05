package Backtracking;

public class Change_Array {
    
    public static void changeArr(int arr[], int i, int val)
    {
        // Base case
        if(i == arr.length)     // (5 == 5)
        {
            printArr(arr);
            return;
        }

        // Recursion
        arr[i] = val;       // [0]1, [1]2, [2]3, [3]4, [4]5
        changeArr(arr, i + 1 , val + 1);

        // Backtracking step
        arr[i] = arr[i] - 1;
    }

    public static void printArr(int arr[])
    {
        for(int i = 0; i< arr.length; i++)
        {
            System.out.print( arr[i] +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        int arr[] = new int[5];

        changeArr(arr, 0, 1);
        printArr(arr);
    }
}
