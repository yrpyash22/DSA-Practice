class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int n = nums.size();
        // Create prefix array of size n + 1
        int ans = Integer.MAX_VALUE;

        int prefix[] = new int[n+1];
        prefix[0] = 0;
        for(int i=0; i<n; i++)
        {
            prefix[i+1] = prefix[i] + nums.get(i);
        }

        // Generate all subarrays
        for(int i=0; i<n; i++)
        {
            for(int j = i; j < n; j++)
            {
                int len = j - i + 1;

                if(len >= l && len <= r)
                {
                    int sum = prefix[j + 1] - prefix[i];
                    if(sum > 0)
                    {
                        ans = Math.min(ans, sum);
                    }
                }
            }
        }
        
        return  ans == Integer.MAX_VALUE ? -1 : ans;
    }
}