class Solution {
    public int singleNonDuplicate(int[] nums) {

        // Input: nums = [1,1,2,3,3,4,4,8,8] 
        int start = 0;
        int end = nums.length - 1;   // 8

        while(start < end)                  // (0<8), (0<4), (0<2), (2<2)!
        {
            int mid = (start + end) / 2;    // 4, 2, 1

            // mid ko even index par le ja rahe hain
            if(mid % 2 == 1)                // (0==1)!, (0==1)!, (0==0)
            {
                mid--;                      // [0]
            }

            // Pair correct hai
            if(nums[mid] == nums[mid+1])   // (3==4)!, (2==3)!, (1==1)
            {
                start = mid +2;             // [0=0+2]2,
            }
            else{       // // Single element left side mein hai
                end = mid;                  // [8=4]4, [4=2]2,
            }
        }

        return nums[start];   // 2
    }
}