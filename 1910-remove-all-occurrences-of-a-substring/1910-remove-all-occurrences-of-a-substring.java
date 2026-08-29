class Solution {
    public String removeOccurrences(String s, String part) {

        // Ex ==> Input: s = "daabcbaabcbc", part = "abc"
        
        while(s.contains(part))   // (T), (T), (T)
        {
            // part ka leftmost index find karo
            int index = s.indexOf(part);        // 2, 4, 3

            // part ko remove karke or new sting banegi
            s = s.substring(0, index) + s.substring(index + part.length());  // [(0,2)+(2+3)]{dabaabcbc}, [(0,4)+(4+3)]{dababc}, [(0,3)+(3+3)]{dab}
        }
        return s;   // dab
    }
}