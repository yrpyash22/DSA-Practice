class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        

        // Input: seq = "(()())"

        int n = seq.length();          // 6
        int ans[] = new int[n];
        int depth = 0;

        for(int i =0; i<n; i++)     // 0, 1, 2, 3, 4, 5
        {
            if(seq.charAt(i) == '(')
            {
                depth++;                // 1, 2, 2
                // Odd depth => group 0, even depth => group 1
                ans[i] = depth % 2;     //[1], [1,0], [1,0,0,0], [1...,1]
            }
            else{
                // for ')' beacket is at current depth--
                ans[i] = depth % 2;     // [1,0,0], [1,0,0,0,0]
                depth--;                // 1, 1, 
            }
        }
        return ans;
    }
}