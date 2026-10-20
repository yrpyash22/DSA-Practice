class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;
            int prevLast = Integer.MIN_VALUE;

            for (int start = 0; start < n; start += k) {
                int descents = 0;
                int descentIndex = -1;

                for (int i = start; i < start + k - 1; i++) {
                    if (nums[i] > nums[i + 1]) {
                        descents++;
                        descentIndex = i;
                    }
                }

                if (descents > 1) {
                    valid = false;
                    break;
                }

                int first;
                int last;

                if (descents == 0) {
                    first = nums[start];
                    last = nums[start + k - 1];
                } else {
                    if (nums[start + k - 1] > nums[start]) {
                        valid = false;
                        break;
                    }

                    first = nums[descentIndex + 1];
                    last = nums[descentIndex];
                }
                
                if (first < prevLast) {
                    valid = false;
                    break;
                }

                prevLast = last;
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}