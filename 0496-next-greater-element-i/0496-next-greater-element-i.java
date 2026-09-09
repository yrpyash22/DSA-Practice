class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        // Input: nums1 = [4,1,2], nums2 = [1,3,4,2]

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();


        // find next greater elemant in num2 arr
        for(int i = 0; i<nums2.length; i++)     // 0,1,2,3
        {
            int curr = nums2[i];                // 1, 3, 4, 2

            while(!stack.isEmpty() && curr > stack.peek())   // (F&)!, (T&3>1), (T&4>3), (T&2>4)!
            {
                int small = stack.pop();    // 1, 3

                map.put(small, curr);       //(1|3), (3|4) 
            }
            stack.push(curr);   // [1], [3], [4], [4,2]
        }

        // Remaining element in stack have no greater element
        while(!stack.isEmpty())     // (T), (T)
        {
            map.put(stack.pop(), -1);    // (2|-1), (4|-1) 
        }

        int ans[] = new int[nums1.length];

        for(int i = 0; i< nums1.length; i++)   // 0, 1,2
        {
            ans[i] = map.get(nums1[i]);    // [(4)[-1]], [(1)[3]], [(2)[-1]]
        }

        return ans;     //[-1, 3, -1]
    }
}