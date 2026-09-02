class Solution {
    public List<List<String>> partition(String s) {
    
        List<List<String>> r = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), r);

        return r;
    }

    public void backtrack(String s, int start, List<String> curr, List<List<String>> r)
    {
        // Pura string partition ho gaya
        if(start == s.length())
        {
            r.add(new ArrayList<>(curr));
            return;
        }

        // Har possible substring try karo
        for(int i = start; i<s.length(); i++)
        {
            // Check karo substring palindrome hai ya nahi
            if(isPalindrome(s, start, i))
            {
                // Choose
                curr.add(s.substring(start, i + 1));


                // Remaining string par recursion
                backtrack(s, i + 1, curr, r);

                // Backtrack
                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end)
    {
        while(start < end)
        {
            if(s.charAt(start) != s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}