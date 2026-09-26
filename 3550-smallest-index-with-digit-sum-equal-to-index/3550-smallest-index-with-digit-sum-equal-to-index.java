class Solution {
    public int smallestIndex(int[] nums) {
    
        // Input: nums = [1,3,2]

        for(int i =0; i<nums.length; i++)  //0, 1, 2
        {
            int val = nums[i];  // 1, 3, 2
            int sum = 0;

            while(val > 0)  // (1>0), (0>0)!, (3>0), (0>0)!, (2>0), (0>0)!
            {
                sum = sum + (val % 10); // [1], [3], [2]
                val = val / 10;         // [0], [0], [0]
            }

            if(sum == i)  // (1==0)!, (3==1)!, (2==2)
            {
                return i;  // 2
            }
        }
        return -1;
    }
}