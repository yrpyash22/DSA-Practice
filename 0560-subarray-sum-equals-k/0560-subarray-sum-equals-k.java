class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Example ==>  Input: nums = [1,2,3], k = 3
        // Iska matlab starting se hi prefix sum 0 ek baar exist karta hai.
        map.put(0, 1);  // [0->1]

        int sum =0;
        int count = 0;

        for(int i=0; i<nums.length; i++)       // i = 0, 1, 2
        {
            // Current prefix sum calculate karta hai.
            sum = sum + nums[i];    // [s=0+1]1, [1=1+2]3, [3=3+3]6

            // Check karta hai ki required previous prefix sum available hai ya nahi.
            if(map.containsKey(sum - k)) // (1-3)!, (3-3)0, (6-3)3
            {
                // Jitni baar sum-k aaya hai, utne valid subarrays milenge.
                count += map.get(sum - k);      // c=1, c=2
            }
            // Current prefix sum ki frequency store karta hai.  Agar sum pehle se map me hai → uski frequency + 1
            map.put(sum, map.getOrDefault(sum, 0) + 1);     // [1->0+1], [3->0+1], [6->0+1] 
        }
        return count;       // 2
    }
}