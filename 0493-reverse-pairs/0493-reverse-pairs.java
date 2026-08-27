class Solution {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int left, int right) {

        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int count = 0;

        // Left half
        count += mergeSort(nums, left, mid);

        // Right half
        count += mergeSort(nums, mid + 1, right);

        // Count reverse pairs
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {

            while (j <= right &&
                   (long) nums[i] > 2L * nums[j]) {
                j++;
            }

            count += j - (mid + 1);
        }

        // Merge both sorted halves
        merge(nums, left, mid, right);

        return count;
    }

    public void merge(int[] nums, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {

            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            nums[left + x] = temp[x];
        }
    }
}







/*
class Solution {
    public int reversePairs(int[] nums) {

        // Input: nums = [1,3,2,3,1]
        int count = 0;
        int n = nums.length;        // 5

        for (int i = 0; i < n; i++)             // 0, 1, 2, 3, 4
        {
            for (int j = i + 1; j < n; j++)     // 1, 2, 3, 4
            {
                // for i = 0 ==> (1 > 2×3)!, (1 > 2×2)!, (1 > 3×2)!, (1 > 2×1)!
                // for i = 1 ==> (3 > 2×2)!, (3 > 2×3)!, (3 > 2x1)
                // for i = 2 ==> (2 > 2×3)!, (2 > 2×1)!
                // for i = 3 ==> (3 > 2×1)
                if ((long)nums[i] > 2L * nums[j])  
                {
                    count++;   // (1,4), (3,4)
                }
            }
        }

        return count;  // 2
    }
}
*/