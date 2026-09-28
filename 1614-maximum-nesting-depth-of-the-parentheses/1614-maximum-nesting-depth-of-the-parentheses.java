class Solution {
    public int maxDepth(String s) {
        

        /*
        Stack<Character> st = new Stack<>();
        int maxDepth = 0;
        for(int i =0; i<s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                st.push(s.charAt(i));
                maxDepth = Math.max(maxDepth, st.size());
            }
            else if(s.charAt(i) == ')')
            {
                st.pop();
            }
        }
        return maxDepth;
        */

        
        int depth = 0;
        int maxDepth = 0;
        for(int i = 0; i<s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            }
            else if(s.charAt(i) == ')')
            {
                depth--;
            }
        }
        return maxDepth;
    }
}