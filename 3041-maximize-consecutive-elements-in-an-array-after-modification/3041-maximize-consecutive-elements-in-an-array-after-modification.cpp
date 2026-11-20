class Solution {
public:
    int maxSelectedElements(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int ans = 0;

        int maxVal = nums.back() + 2;
        vector<int> dp(maxVal, 0);

        for(int num : nums)
        {
            // Option 1: increment num -> num + 1
            dp[num +1] = max(dp[num+1], dp[num] +1);

            // Option 2: keep num as is
            dp[num] = max(dp[num], dp[num -1] +1);
            
            ans = max({ans, dp[num], dp[num +1]});
        }

        return ans;
    }
};


