class Solution {
    public String removeOuterParentheses(String s) {
        
        int depth = 0;
        String res = "";

        for(char ch : s.toCharArray())
        {
            if(ch == '(')
            {
                if(depth > 0)
                {
                    res = res + "(";
                }
                depth++;
            }
            else{
                depth--;
                if(depth > 0)
                {
                    res = res + ")";
                }
            }
        }

        return res;
    }
}