class Solution {
    public int longestValidParentheses(String s) {

        // Input: s = "(()"

        Stack<Integer> st = new Stack<>();

        st.push(-1);
        int max = 0;

        for(int i = 0; i<s.length(); i++)     // 0,1,2
        {
            // Push
            if(s.charAt(i) == '(')        //('('), ('('), (')')
            {
                st.push(i);               // [0], [0,1]
            }
            else{
                st.pop();           // [0]

                if(st.isEmpty())     // (F)!
                {
                    st.push(i);
                }
                else{
                    int len = i - st.peek();        // [2-0]2
                    max = Math.max(max, len);       // (0,2)2
                }
            }
        }

        return max;          // 2
    }
}