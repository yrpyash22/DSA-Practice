package String;

/*
// Rabin-Karp Algorithm
Rabin-Karp is a string searching algorithm that uses hashing to find a pattern in a text. It compares the hash value of the pattern with the hash value of each substring of the same length. If the hash values match, the actual characters are compared to confirm the match.
Advantages:
Hashing use karta hai.
Multiple patterns search karne mein useful ho sakta hai.
Average case mein efficient.
Disadvantage:
Hash collision ho sakta hai.
Worst case time complexity O(n × m) ho sakti hai.
Complexity

Simple code jo upar diya hai:

Time:  O(n × m)
Space: O(1)

Example:
Text    = "ABABCABAB"
Pattern = "ABAB"

Basic idea: Pattern aur text ke same-size part ka hash compare karo.

        Pattern = ABAB
                   ↓
                Hash = 10

Text ka first 4 characters:
ABAB
 ↓
Hash = 10


==> Simple Steps
1. Pattern ka hash nikalo
2. Text ke first window ka hash nikalo
3. Dono hash compare karo
4. Same hai → strings compare karo
5. Same nahi hai → next window par jao
6. Repeat

Example: Text = "ABABCABAB", Pattern = "ABAB"
Windows:
ABAB  ← compare
BABC
ABCA
BCAB
CABA
ABAB  ← compare



*/

public class RabinKarp {

    public static int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        // Pattern ka simple hash
        int patternHash = 0;

        for (int i = 0; i < m; i++) 
        {
            patternHash = patternHash + pattern.charAt(i);
        }

        // Text ki har window check karo
        for (int i = 0; i <= n - m; i++) 
        {
            int textHash = 0;

            // Current window ka hash
            for (int j = 0; j < i + m; j++) 
            {
                textHash = textHash + text.charAt(j);
            }

            // Hash same hai
            if (patternHash == textHash) 
            {
                // Actual string compare
                boolean match = true;

                for (int j = 0; j < m; j++) 
                {
                    if (text.charAt(i + j) != pattern.charAt(j)) 
                    {
                        match = false;
                        break;
                    }
                }

                if (match) 
                {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String text = "ABABCABAB";
        String pattern = "ABAB";

        int result = search(text, pattern);

        System.out.print(result);
    }
}
