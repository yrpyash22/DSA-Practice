class Solution {
    public String digitSum(String s, int k) {
        
        // s = "11111222223"   k = 3

        int n = s.length();      // 11

        while(n > k)   // (11>3), (4>3), (3>3)!
        {
            StringBuilder strb = new StringBuilder();

            for(int i =0; i<n; i += k)       // 0,3,6,9  | 0,3
            {
                int sum =0;

                int comp  = Math.min(i + k, n);     // (3,11)3, (6, 11), (9,11), (12,11)11 | (3,4)3, (6,4)4

                for(int j = i; j<comp; j++)             //0,1,2, 3,4,5, 6,7,8, 9,10  | 0,1,2 | 3
                {
                    sum = sum + s.charAt(j) - '0';      // 111(3), 112(4), 222(6), 23(5) | 346(13), 5(5)
                }

                strb.append(sum);     // ["3",], ["3", "4"], ["3","4","6"], ["3","4","6","5"]  | ["13"], ["13", "5"]
            }

            s = strb.toString();        // 3465 , 135
            n = s.length();             // 4, 3
        }

        return s;  // 135
    }
}