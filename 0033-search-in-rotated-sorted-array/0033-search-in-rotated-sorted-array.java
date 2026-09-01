class Solution {
    public int search(int[] nums, int target) {
        
        // nums = [4,5,6,7,0,1,2], target = 0
        int start = 0;
        int end = nums.length - 1;      // 6

        while(start <= end)  // (0<6), (4<6), (4<=4)
        {
            int mid = (start + end )/ 2;    //3, 5, 4

            // Agar target mil jaye to
            if(nums[mid] == target)     // (7==0)!, (1==0)!, (0==0)
            {
                return mid;         // 4
            }
            
            // left half sorted hai
            if(nums[start] <= nums[mid])        // (4<=7), (0<=1)
            {
                // Target left half ke ander hai 
                if(nums[start] <= target && nums[mid] > target) // (4<=0 && 7>0)!, (0<=0 && 1>0)
                {
                    end = mid - 1;      // [6=5-1]4,
                }
                else{
                    start = mid + 1;        // [0=3+1]4, 
                }
            }  // agar right half short hai to
            else{
                // Target right half ke andar hai
                if(nums[mid] < target && nums[end] >= target)
                {
                    start = mid +1;
                }
                else{
                    end = mid -1;
                }
            }
        }
        return -1;
    }
}