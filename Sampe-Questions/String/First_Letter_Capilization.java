package String;

// [Q-4] For a given string convert each the first letter oof each words to uppercase.
    // eex = "hi i am yashraj" =  " Hi I Am Yashraj"
    // Character.toupperCase(str);
public class First_Letter_Capilization {
    
    public static String to_upperCase(String str)
    {
        StringBuilder strb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        strb.append(ch);
        
        for(int i = 1; i<str.length(); i++)
        {
            if(str.charAt(i) == ' ' && i<str.length()-1)
            {
                strb.append(str.charAt(i));
                i++;
                strb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                strb.append(str.charAt(i));
            }
        }
        return strb.toString();
    }

    public static void main(String[] args) {

        String strb_1 = "hi i am yashraj";

        System.out.println(to_upperCase(strb_1));
    }

}
