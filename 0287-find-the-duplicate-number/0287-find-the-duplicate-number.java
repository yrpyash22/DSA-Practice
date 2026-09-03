class Solution {
    public int findDuplicate(int[] nums) {

        /*
        Ex-> nums = [1,3,4,2,2]
        index:  0  1  2  3  4
        value:  1  3  4  2  2
        */


        int slow = nums[0];     // 1
        int fast = nums[0];     // 1

        // Step 1: Find intersection point
        do {
            slow = nums[slow];       // Slow 1 step move karta hai.  1 → 3 → 2 → 4 → 2
            fast = nums[nums[fast]]; // fast 2 step move karta hai.  1 → 2 → 4 → 2 → 4
        } while (slow != fast);     // (3!=2), (2!=2)!

        // Step 2: Find entrance of cycle
        slow = nums[0];     // [s=1]

        while (slow != fast)        // (1!=2), (3!=4), (2!=2)!
        {
            slow = nums[slow];      // 3, 2
            fast = nums[fast];      // 4, 2
        }

        return slow;  // 2
    }
}