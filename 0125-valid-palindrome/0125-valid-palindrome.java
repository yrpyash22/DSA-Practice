class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() -1;

        while(left < right)
        {
            // Non-alphanumeric character skip karo  from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) 
            {
                left++;
            }
            // Non-alphanumeric character skip karo  from righht
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Lowercase karke compare karo
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) 
            {
                return false;
            }

            left++;
            right--;
        }
 
        /* // Simple approach
        for(int i = 0; i<s.length()/2; i++)
        {
            int n = s.length();
            if(s.charAt(i) != s.charAt(n - i - 1))
            {
                return false;
            }
        }
        */
        return true;
    }
}