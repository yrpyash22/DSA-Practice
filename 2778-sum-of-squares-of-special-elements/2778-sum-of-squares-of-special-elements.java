class Solution {
    public int sumOfSquares(int[] nums) {
        
        // Input: nums = [1,2,3,4]

        int n = nums.length;   // 4
        int sum = 0;
        for(int i = 1; i<=n; i++)   // 0,1,2,3
        {
            if(n % i == 0)   // (4 % 1 ==0), (4 % 2 == 0), (4 % 3 == 0)!, (4 % 4 == 0)
            {
                sum += nums[i-1] * nums[i-1];   // [0+1*1]1, [1+2*2]5, [5+4*4]21
            }
        }
        return sum;
    }
}