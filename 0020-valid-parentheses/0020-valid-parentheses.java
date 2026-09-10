class Solution {
    public boolean isValid(String str) {
        
        Stack<Character> s = new Stack<>();

        for(char ch : str.toCharArray())
        {
            if(ch == '(' || ch == '[' || ch == '{')
            {
                s.push(ch);
            }
            else{
                if(s.isEmpty())
                {
                    return false;
                }

                char top = s.peek();

                if((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{'))
                {
                    s.pop();
                }
                else{
                    return false;
                }
            }
        }
        return s.isEmpty();
    }
}