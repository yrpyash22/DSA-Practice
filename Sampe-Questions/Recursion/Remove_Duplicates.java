package Recursion;

public class Remove_Duplicates {


    public static void remDuplicate(String str, int idx, StringBuilder newstr, boolean map[])
    {
        if(idx == str.length())
        {
            System.out.println(newstr);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true)    // duplicate
        {
            remDuplicate(str, idx + 1, newstr, map);
        }
        else{
            map[currChar - 'a'] = true;
            remDuplicate(str, idx + 1, newstr.append(currChar), map);
        }
    }

    public static void main(String[] args) {

        String str = "yashraj";
        remDuplicate(str, 0, new StringBuilder(), new boolean[26]);
    }
}
