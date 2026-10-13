class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        int n = nums.length;
        long arr[] = new long[n];

        for(int i = 0; i< n; i++)
        {
            arr[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(arr);

        long score=0;

        for(int i = 0; i<n; i++)
        {
            if(i < n/2)
            {
                score = score - arr[i];
            }
            else{
                score = score + arr[i];
            }
        }

        return score;
    }
}
