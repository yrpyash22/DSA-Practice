class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        // nums = [1,2,1]

        Stack<Integer> s = new Stack<>();
        int n = nums.length;            //3 
        int result[] = new int[n];

        // Initially, assume no greater element exists
        for(int i = 0; i<n; i++)   // 0, 1, 2
        {
            result[i] = -1;  // [-1,-1,-1]
        }

        // Traverse array twice
        for(int i = 0; i< 2*n; i++)   // (0, 1, 2, 3, 4, 5)
        {
            // % n makes the array circular formate of traverser
            int curr = nums[i % n];    // 0, 1, 2, 0, 1, 2

            // Find next greater element
            while(!s.isEmpty() && nums[s.peek()] < curr)  // (F)!, (T&1<1)!, (T&1<2)!,....
            {
                int idx = s.pop();          // 0
                result[idx] = curr;         // [2, -1, -1], [2,-1,-1], [2,-1,2]
            }

            // Only push indices during first traversal
            if(i < n)   // (0<3), (1<3), (2<3), (3<3)!
            {
                s.push(i);  //[0], [0,1], [0,1,2]
            }
        }
        return result;
    }
}