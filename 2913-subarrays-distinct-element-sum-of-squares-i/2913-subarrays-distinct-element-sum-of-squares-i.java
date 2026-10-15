class Solution {
    public int sumCounts(List<Integer> nums) {
        
        // Input: nums = [1, 2, 1]

        int n = nums.size();       // 3
        int sum = 0;

        for(int i = 0; i<n; i++)   // 0, 1, 2
        {
            HashSet<Integer> set = new HashSet<>();

            for(int j =i; j<n; j++)     // 0,1,2
            {
                set.add(nums.get(j));   //i=0/ [1], [1,2], [1,2]   //(1) [2], [2,1]    //(2) [1] 

                int count = set.size();     // 1, 2, 3  // 1, 2   // 1
                sum = sum + count * count;  // [0+1*1]1, [1+2*2]5, [5+2*2]9  // [9+1*1]10, [10+2*2]14  // [14+1*1]15
            }
        }

        return sum;    // 15
    }
}