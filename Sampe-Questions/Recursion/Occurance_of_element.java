package Recursion;

public class Occurance_of_element {
    

    // First occurance of an element 
    public static int firstOccurance(int arr[], int key, int i)
    {
        if(i == arr.length)
        {
            return -1;
        }
        if(arr[i] == key)
        {
            return i;
        }
        return firstOccurance(arr, key, i+1);
    }


    // Last occurance of an element
    public static int lastOccurance(int arr[], int key, int i)
    {
        if(i == arr.length)
        {
            return -1;
        }
        int isfound = lastOccurance(arr, key, i+1);

        if(isfound == -1 && arr[i] == key)
        {
            return i;
        }
        return isfound;
    } 


    public static void main(String[] args) {
        int arr[] = {8, 3, 6, 9, 3, 10, 2, 3, 5};
        System.out.println("First Occurance: :" + firstOccurance(arr, 3, 0));
        System.out.println("First Occurance: :" + lastOccurance(arr, 3, 0));
    }
}
