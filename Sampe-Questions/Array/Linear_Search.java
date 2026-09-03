package Array;

public class Linear_Search {

    public static int linearSearch(int nums[], int key)
    {
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i] == key)
            {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String args[])
    {
        int nums[] = {2, 4, 6, 8, 9, 5, 4 ,10 , 7, 22, 41};
        int key = 10;
        System.out.print("Value Index at: "+ linearSearch(nums, key));
    }
}
