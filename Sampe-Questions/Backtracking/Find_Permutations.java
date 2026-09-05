package Backtracking;

public class Find_Permutations {
    

    public static void findPermutation(String str, String ans)
    {
        // Base case
        if(str.length() == 0)
        {
            System.out.println(ans);
            return;
        }

        // Recursion on backtracking
        for(int i =0; i< str.length(); i++)
        {
            char curr = str.charAt(i);

            String newstr = str.substring(0, i) + str.substring(i+1);

            findPermutation(newstr, ans + curr);
        }
    }

    public static void main(String[] args) {
        String str = "abc";

        findPermutation(str, "");
    }
}
