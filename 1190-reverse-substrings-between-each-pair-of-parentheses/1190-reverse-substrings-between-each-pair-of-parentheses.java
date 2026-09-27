class Solution {
    public String reverseParentheses(String s) {
        
        Stack<String> st = new Stack<>();
        StringBuilder curr = new StringBuilder();

        for(int i =0; i<s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                // // Save current string
                st.push(curr.toString());
                
                // Start again a  new string
                curr = new StringBuilder();
            }
            else if(s.charAt(i) == ')')
            {
                // Reverse current string
                curr.reverse();
                String prev = st.pop();

                // Join previous + reversed current
                curr = new StringBuilder(prev + curr);
            }
            else{
                curr.append(s.charAt(i));
            }
        }
        return curr.toString();
    }
}