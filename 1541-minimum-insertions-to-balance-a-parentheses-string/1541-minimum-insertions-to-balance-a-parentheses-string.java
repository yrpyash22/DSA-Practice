class Solution {
    public int minInsertions(String s) {
        
        // Dry run: s = "(()))"

        int n = s.length();      // 5
        int open = 0;
        int insertion = 0;

        int i =0;
        while(i < n)        // (0<5), (1<5), (2<5), (4<5), (5<5)!
        {
            if(s.charAt(i) == '(') // (T), (T), (F)!, (F)!
            {
                open++;    // 1, 2
                i++;       // 1, 2
            }
            else{
                if(i+1 < n && s.charAt(i+1) == ')')   // (3<5 && ')' == ')'), (5<5 && .)!
                {
                    // if lagatar )) to 
                    if(open > 0)        // (2>0)
                    {
                        open--;        // 1
                    }
                    else{
                        insertion++;
                    }
                    i = i +2;         // 4
                } 
                else{
                    // agar ) to
                    if(open > 0)       // (1>0)
                    {
                        insertion++;     // 1
                        open--;          // 0
                    }
                    else{
                        insertion += 2;
                    }
                    i++;           // 5
                }
            }
        }

        int res = insertion + open * 2;     // [1+0*2]1
        return res;
    }
}