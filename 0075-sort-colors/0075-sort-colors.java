class Solution {
    public void sortColors(int[] nums) {
        // binary Search
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;

        while(mid <= right)
        {
            if (nums[mid] == 0) {
                // 0 ko left side bhejo
                int temp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = temp;
                left++;
                mid++;
            }
            else if (nums[mid] == 1)
            {   // ye shi jaha per hai 
                mid++;
            }
            else { // 2 ko right side bhejo
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
    }
}