class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) // (i = 0 to 3)
        {
            // Duplicate i skip
            if (i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++)
            {
                // Duplicate j skip
                if (j > i + 1 && nums[j] == nums[j - 1]) 
                {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) 
                {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) 
                    {
                        result.add(Arrays.asList( nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        // Duplicate left skip
                        while (left < right && nums[left] == nums[left - 1]) 
                        {
                            left++;
                        }

                        // Duplicate right skip
                        while (left < right && nums[right] == nums[right + 1]) 
                        {
                            right--;
                        }
                    }

                    else if (sum < target) 
                    {
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}