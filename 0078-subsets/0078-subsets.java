class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();

        solve(nums, 0, new ArrayList<>(), r);
        return r;
    }

    public void solve(int nums[], int start, List<Integer> curr, List<List<Integer>> r)
    {
        // Base case
        if(start == nums.length)
        {
            r.add(new ArrayList<>(curr));
            return;
        }

        // Recursion
        // Don't choose
        solve(nums, start + 1, curr, r);
        curr.add(nums[start]);
        // choose
        solve(nums, start + 1, curr, r);

        // Backtracking
        curr.remove(curr.size() - 1);

    }
}