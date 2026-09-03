package Array;

public class Largest_Number {

    public static int getLargest(int nums[])
    {
        int largest = Integer.MIN_VALUE;
        for(int i =0; i<nums.length; i++)
        {
            if(largest < nums[i])
            {
                largest = nums[i];
            }
        }
        return largest;
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 8, 9, 45, 5};
        System.out.print("Largest number: "+ getLargest(arr));
    }
}
