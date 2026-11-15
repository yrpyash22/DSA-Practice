class Solution {
    public int numOfSubarrays(int[] arr) {

        // Input: arr = [1,3,5]
        
        int MOD = 1000000007;
        int n = arr.length;    // 3
        long ans = 0;

        long odd = 0;
        long even = 1;

        int prefSum = 0;

        for(int i=0; i<n; i++)    // 0, 1, 2
        {
            prefSum = prefSum + arr[i];  // 1, 4, 9
            
            if(prefSum % 2 != 0)    // (1!=0), (4!=0)!, (9!=0)
            {
                ans = (ans + even) % MOD;    // 1, 4
                odd++;               // 1, 2
            }
            else{
                ans = (ans + odd) % MOD;      // 2
                even++;               // 2
            }
            // ans = ans % MOD;      // 1, 2, 4
        }

        return (int) ans;   // 4
    }
}