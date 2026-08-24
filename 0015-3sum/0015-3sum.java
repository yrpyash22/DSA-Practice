class Solution {
    public List<List<Integer>> threeSum(int[] nums)  // [-1,0,1,2,-1,-4]
    {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);     // [-4,-1,-1,0,1,2]

        for (int i = 0; i < nums.length - 2; i++) // (i = 0 to 4)
        {
            // Duplicate first element skip karo
            if (i > 0 && nums[i] == nums[i - 1])  // (), (1 && -1==-4)
            {
                continue;
            }

            int left = i + 1;             // 1,2
            int right = nums.length - 1;  // 5,5

            while (left < right)  //(1<5),(2<5),(3<5),(4<5),(5<5)! | (2<5)
            {
                int sum = nums[i] + nums[left] + nums[right]; 
                // (-4,-1,2)-3, (-4,-1,2)-3, (-4,0,2), (-4,1,2) | (-1,-1,2)=0,

                if (sum == 0) 
                {
                    result.add(Arrays.asList( nums[i], nums[left], nums[right])); // result[[-1,-1,2]]
                    left++;
                    right--;

                    // Duplicate left values skip
                    while (left < right && nums[left] == nums[left - 1]) 
                    {
                        left++;
                    }
                }
                else if (sum < 0)  // -3, -3, -2, -1
                {
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;
    }
}