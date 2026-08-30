class Solution {
    public String longestPrefix(String s) {
    
        // s = "ababab"

        int n = s.length();  // 6

        int lps[] = new int[n];

        int len = 0;

        for(int i = 1; i<n; i++)        // 1, 2, 3, 4, 5
        {
            if(s.charAt(i) == s.charAt(len)) // (b==a)!, (a==a), (b==b), (a==a), (b==b)
            {
                len++;                  // 1, 2, 3, 4
                lps[i] = len;           // [2]{1}, [3]{2}, [4]{3}, [5]{4}
            }
            else{
                if(len > 0)             // (0>0)!
                {
                    len = lps[len - 1];
                    i--;
                }
                else{               
                    lps[i] = 0;        // [1]{0},  
                }
            }
        }

        int longest = lps[n - 1];       // [=[5-1]{4}]
        return s.substring(0, longest);  // [0,4]{abab}
    }
}