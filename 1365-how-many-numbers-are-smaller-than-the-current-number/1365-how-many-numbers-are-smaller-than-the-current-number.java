class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        // nums = [8, 1, 2, 2, 3]

        int n = nums.length;        // 5
        int[] ans = new int[n];     // 5

        for (int i = 0; i < n; i++)  // 0, 1, 2, 3, 4
        {
            int count = 0;
            for (int j = 0; j < n; j++)  // 0, 1, 2, 3, 4
            {
                if (nums[j] < nums[i])   //(8<8)!, (1<8),(2<8),(2<8),(3<8) | (8<1)!, (1<1)!, (2<1)!..
                {
                    count++;        // [4]
                }
            }
            ans[i] = count;  // [[0]{4}], [[1]{0}], ...
        }

        return ans;  // [4, 0, 1, 1, 3]
    }
}