class Solution {
    public int[] concatWithReverse(int[] nums) {

        //  nums = [1,2,3]
        
        int n = nums.length;                // 3
        int result[] = new int[2 * n];      // 6

        for(int i = 0; i<n ; i++)       // 0,1,2
        {
            result[i] = nums[i];         //[0=1], [1=2], [2=3]
            result[i + n] = nums[n-i-1]; //[[3]=[3-0-1]{3}], [[4]={2}], [[5]={1}]
        }
        return result;
    }
}