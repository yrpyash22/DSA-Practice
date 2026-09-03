class Solution {
    public String minWindow(String s, String t) {
        
        // Example s = "AEBANC", t = "ABC"

        if(s.length() < t.length())         // (6<3)!
        {
            return "";
        }

        int freq[] = new int[128];

        // t ke characters ki frequency
        for(char ch : t.toCharArray())
        {
            freq[ch]++;         // [A++, B++, C++]
        }

        int right = 0;   // valid window banao
        int left = 0;    // minimum valid window dhoondo 

        int start = 0;
        int req = t.length();                   // 3   , t ke saare required characters hai ya nahi.
        int min_length = Integer.MAX_VALUE;     // +infinity
        String result;

        while(right < s.length())           // (0<6), (1<6),(2<6),(3<6), (4<6), (5<6)
        {
            char ch = s.charAt(right);      // [A], [E], [B], [A], [N], [C]

            // Agar current character t mein hai to
            if(freq[ch] > 0)            // (1>0), (0>0)!, (1>0), (0>0)!, (0>0)!, (1>0)
            {
                req--;                  // 2, 1, 0
            }

            freq[ch]--;               // [A--], [E--], [B--], [A--], [N--], [C--]
            right++;                  // 1, 2, 3, 4, 5, 6



            // Window valid hai  //  ==> "AEBANC" 
            while(req == 0)         // (2==0)!, (2==0)!..., (0==0), (1==1)!
            {
                // Minum windo ko update karna hoga
                if(right - left < min_length)       // (6-0< +I), (5<6), (4<5)
                {
                    min_length = right - left;      // [6], [5], [4]
                    start = left;                   // [0], [1], [2]
                }

                char leftChar = s.charAt(left);     // [A], [E], [B]

                freq[leftChar]++;       // [A++], [E++], [B++]

                // Agar required character window se bahar gaya
                if (freq[leftChar] > 0)   // (0>0)!, (0>0)!, (1>0)
                {
                    req++;              
                }

                left++;             // 1, 2, 3
            }
        }

        if(min_length == Integer.MAX_VALUE)
        {
            return "";
        }

        result = s.substring(start, start + min_length);   // (2, 2+3){BANC}

        return result;  // BANC
    }
}