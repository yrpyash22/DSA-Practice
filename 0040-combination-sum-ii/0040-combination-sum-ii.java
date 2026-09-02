class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    public void backtrack(int cand[], int target, int start, List<Integer> curr, List<List<Integer>> result)
    {
        // Target complete
        if (target == 0)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i<cand.length; i++)
        {
            // Duplicate skip
            if (i > start && cand[i] == cand[i - 1])
            {
                continue;
            }

            // Candidate target se bada hai
            if (cand[i] > target) 
            {
                break;
            }

            // Choose
            curr.add(cand[i]);

            // i + 1 because each number can be used only once
            backtrack(cand, target - cand[i], i + 1, curr, result);

            // Backtrack
            curr.remove(curr.size() - 1);
        }
    }
}