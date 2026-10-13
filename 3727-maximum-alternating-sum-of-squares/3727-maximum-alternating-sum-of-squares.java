class Solution {
    public long maxAlternatingSum(int[] nums) {

        // nums = [1, 2, 3]
        
        int n = nums.length;     // 3
        long arr[] = new long[n];

        for(int i = 0; i< n; i++)   // 0,1,2
        {
            arr[i] = (long) nums[i] * nums[i];   //[1], [1,4], [1,4,9]
        }

        Arrays.sort(arr);   // [1,4,9]

        long score=0;

        for(int i = 0; i<n; i++)   // 0, 1, 2
        {
            if(i < n/2)   // (0 < 1), (1<1)!, (2<1)!
            {
                score = score - arr[i];  // [0-1]-1,
            }
            else{
                score = score + arr[i];  // [-1+4]3, [3+9]12
            }
        }

        return score;      // 12
    }
}
