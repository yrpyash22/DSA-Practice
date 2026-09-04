package Recursion;

public class Binary_String_problem {

    // Without Consutative 1s, or 0s
    // ex: 11 X,  00 X

    public static void print_Binary_String(int n, int lastPlace, String str)
    {
        if(n == 0)
        {
            System.out.println(str);
            return;
        }

        print_Binary_String(n -1 , 0, str + "0");
        if(lastPlace == 0)
        {
            print_Binary_String(n -1 , 1, str + "1");
        }
    }


    public static void main(String[] args) {
        print_Binary_String(3, 0, "");   
    }
}
