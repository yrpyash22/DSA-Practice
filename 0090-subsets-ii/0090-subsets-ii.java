class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> r = new ArrayList<>();

        Arrays.sort(nums);

        solve(nums, 0, new ArrayList<>(),r);

        return r;
    }


    public void solve(int nums[], int start, List<Integer> curr,List<List<Integer>> r)
    {
        // Current subset ko result mein add
        r.add(new ArrayList<>(curr));


        // Aage ke elements try karo
        for(int i = start; i<nums.length; i++)
        {
            // Ye line duplicate subsets ko prevent karti hai.
            if (i > start && nums[i] == nums[i - 1]) 
            {
                continue;
            }

            // Element choose karo
            curr.add(nums[i]);

            // Recursion
            solve(nums, i + 1, curr, r);

            // Backtrack
            curr.remove(curr.size() - 1);
        }

    }
}