package String;

public class String_Compression {
    

    public static String compress_string(String str)
    {
        StringBuilder strb = new StringBuilder();

        for(int i = 0; i<str.length(); i++)
        {
            Integer count = 1;
            while (i<str.length()-1 && str.charAt(i)== str.charAt(i+1)) 
            {
                count++;
                i++;    
            }
            strb.append(str.charAt(i));
            if(count>1)
            {
                strb.append(count.toString());
            }
            if(count == 1)
            {
                strb.append(count.toString());
            }
        }
        return strb.toString();
    }


    public static void main(String[] args) {
        
        String comp = "aaabbcccddxn";

        System.out.println(compress_string(comp));

    }
}
