import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {

        // Convert both strings into lowercase
        String s1 = s.toLowerCase();
        String s2 = t.toLowerCase();

        // If length is different, they cannot be anagrams
        if (s1.length() == s2.length()) {

            // Convert strings into character arrays
            char[] s1_ch_array = s1.toCharArray();
            char[] s2_ch_array = s2.toCharArray();

            // Sort the array elements
            Arrays.sort(s1_ch_array);
            Arrays.sort(s2_ch_array);

            // Compare both arrays
            boolean result = Arrays.equals(s1_ch_array, s2_ch_array);

            return result;
        }

        return false;
    }
}