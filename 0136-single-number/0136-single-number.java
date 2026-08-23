class Solution {
    public int singleNumber(int[] nums) {
       int result = 0;

        for (int i = 0 ; i < nums.length; i++) 
        {
            result = result ^ nums[i];  // 0^2=2, 2^2=0, 0^1=1 
                                        // 0^4=4, 4^1=5, 5^2=7, 7^1=6, 6^2=4   
        }
        return result;
    }
}