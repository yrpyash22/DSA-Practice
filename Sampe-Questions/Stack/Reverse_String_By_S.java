package Stack;

import java.util.Stack;


public class Reverse_String_By_S {
    
    public static String rverseString(String str)
    {
        Stack<Character> s = new Stack<>();

        int idx= 0;
        while(idx < str.length())
        {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty())
        {
            char curr = s.pop();
            result.append(curr);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "ABCDE";

        System.out.println(str);
        System.out.println(rverseString(str));        
    }
}
