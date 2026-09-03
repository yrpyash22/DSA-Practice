class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        // candidates = [2,3,6,7], target = 7

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    public void backtrack(int cand[], int target, int start, List<Integer> curr, List<List<Integer>> result)
    {
        // Target completed (base logic)
        if(target == 0)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        // Try all candidates
        for(int i = start; i<cand.length; i++ )
        {
            // Too long value of candidate (skip kar dena hai)
            if(cand[i] > target)
            {
                continue;
            }

            // Choose value
            curr.add(cand[i]);


            // i is passed again because same number // can be used unlimited times
            backtrack(cand, target - cand[i], i, curr, result);

            // UnChoise remove value
            curr.remove(curr.size() - 1);
        }
    }
}