package Stack;

import java.util.Stack;

public class Parentheses_Stack {
    

    // Check Valid Paranthesis
    public static boolean isValid(String str)
    {
        Stack<Character> s = new Stack<>();

        for(int i =0; i<str.length(); i++)
        {
            char ch = str.charAt(i);

            if(ch == 'C' || ch == '{' || ch == '[')
            {
                s.push(ch);
            }
            else{
                if(s.isEmpty())
                {
                    return false;
                }
                if(s.peek() == '(' && ch == ')' || s.peek() == '{' && ch == '}' || s.peek() == '[' && ch == ']')
                {
                    s.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(s.isEmpty())
        {
            return true;
        }
        else{
            return false;
        }
    }


    // Duplicate Parenthesis
    public static boolean isDulicate(String str)
    {
        Stack<Character> s = new  Stack<>();

        for(int i = 0; i<str.length(); i++)
        {
            char ch = str.charAt(i);

            // Closing
            if(ch == ')')
            {
                int count = 0;
                while(s.peek() != '(')
                {
                    s.pop();
                    count++;
                }

                // Duplicate
                if(count < 1)
                {
                    return true;
                }
                else{
                    s.pop();
                }
            }
            else{
                // Opening
                s.push(ch);
            }
        }
        return false;
    }
}
