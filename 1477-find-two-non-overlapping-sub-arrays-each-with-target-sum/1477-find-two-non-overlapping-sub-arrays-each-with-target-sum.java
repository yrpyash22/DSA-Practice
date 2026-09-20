class Solution {
    public int minSumOfLengths(int[] arr, int target) {
    
        int n = arr.length;

        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        int left = 0;
        int sum = 0;

        int ans = Integer.MAX_VALUE;

        for(int right = 0; right < n; right++)
        {
            sum = sum + arr[right];

            while (sum > target)
            {
                sum = sum - arr[left];
                left++;
            }

            // Previous best ko carry forward karo
            if (right > 0)
            {
                best[right] = best[right - 1];
            }

            // Current subarray ka sum target hai
            if(sum == target)
            {
                int currentLength = right - left + 1;

                // Previous subarray [0 ... left-1] mein honi chahiye
                if(left > 0 && best[left - 1] != Integer.MAX_VALUE)
                {
                    ans = Math.min( ans, currentLength + best[left - 1]);
                }

                // Current subarray future ke liye best ho sakti hai
                best[right] = Math.min( best[right], currentLength);
            }
        }
        
        if(ans == Integer.MAX_VALUE)
        {
            return -1;
        }
        else{
            return ans;
        }
    }
}

