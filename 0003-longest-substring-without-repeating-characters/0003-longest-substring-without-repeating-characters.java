class Solution {
    public int lengthOfLongestSubstring(String s) {

        // Ex-> s = "abcabcbb"
        HashSet<Character> set = new HashSet<>();

        int on_char = 0;
        int maxLength = 0;

        for(int i = 0; i< s.length(); i++)
        {
            // Agar Duplicate character mila
            while(set.contains(s.charAt(i)))  // ((a)), (a(b)), (ab(c)), (abc(a)), (abc(b)), (abc(c)), (abc(b)), (abc(b))
            {
                set.remove(s.charAt(on_char));  // (abc(a)), (abc(b)), (abc(c)), (abc(b)), (abc(b))
                on_char++;                      // 1, 2, 3, 4, 5
            }
            // Current character add karo
            set.add(s.charAt(i));       // a, b, c

            // Maximum length update karo
            maxLength = Math.max(maxLength, i - on_char + 1); // (0,1)1, (1,2)2, (2,3)3
        }
        return maxLength;
    }
}