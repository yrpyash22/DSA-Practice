class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        backTracking(res, "", 0, 0, n);

        return res;
    }

    public void backTracking(List<String> res, String curr, int open , int close, int n)
    {
        // Base case
        if(n == open && n == close)
        {
            res.add(curr);
            return;
        }

        // Compression    (close < open < n)
        // add "("
        if(open < n)
        {
            backTracking(res, curr + "(", open+1, close, n);
        }

        // add ")"
        if(close < open)
        {
            backTracking(res, curr+ ")", open, close+1, n);
        }
    }
}