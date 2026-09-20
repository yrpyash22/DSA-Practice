class Solution {
    public String longestPalindrome(String s) {
        
        // Input: s = "babad"

        int st = 0;
        int end = 0;

        for(int i =0; i<s.length(); i++)   // 0,1,2,3,4
        {
            // Odd length palindrome
            int odd = expendAroundCenter(s, i, i);     // -1

            int even = expendAroundCenter(s, i, i+1);  // 

            int length = Math.max(odd, even);

            // Update longest palindrome
            if(length > end - st +1)
            {
                st = i -(length -1 )/2;
                end = i+ length/2;
            }
        }
        return s.substring(st, end+1);
    }



    public int expendAroundCenter(String s, int left, int right)
    {
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }

        // Length of palindrome
        return right - left - 1;
    }
}