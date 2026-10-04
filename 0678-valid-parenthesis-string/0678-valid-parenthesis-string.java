class Solution {
    public boolean checkValidString(String s) {

        // Input: s = "(*))"

        int a = 0;
        int b = 0;

        for(int i =0; i<s.length(); i++)     // 0, 1, 2, 3
        {
            char ch = s.charAt(i);       // (, *, ), )
            if(ch == '(')
            {
                a++;                    // 1,
                b++;                    // 1,
            }
            else if(ch == ')')
            {
                a--;                    // -1, -1
                b--;                    // 1, 0
            }
            else{
                a--;                    // 0
                b++;                    // 2
            }

            if(b < 0)                   
            {
                return false;
            }
            a = Math.max(0, a);       // 1,0,0,0
        }

        return a == 0;     // (T)
    }
}