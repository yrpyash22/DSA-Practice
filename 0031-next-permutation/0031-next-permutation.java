class Solution {
    public void nextPermutation(int[] nums) {
        // Input: nums = [1,2,3]
        int n = nums.length; // 3

        // Step 1: Find the first decreasing element from right
        int i = n - 2;  // 1
        while (i >= 0 && nums[i] >= nums[i + 1])  // (1>=0 && 2>=3)
        {
            i--;
        }

        // Step 2: Find element just greater than nums[i]
        if (i >= 0)                        // 1
        {
            int j = n - 1;                 // 2
            while (nums[j] <= nums[i])     // (3<=2) 
            {
                j--;
            }
            // Step 3: Swap        (3<=>2)
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // Step 4: Reverse the elements after i
        int left = i + 1;       // 2
        int right = n - 1;      // 2

        while (left < right) 
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
        // final => [1,3,2]
    }
}