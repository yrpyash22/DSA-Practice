class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // nums = [1,3,-1,-3,5,3,6,7], k = 3
        
        int n = nums.length;     // 8
        int result[] = new int[n - k+1];  //8-3+1= 6

        Deque<Integer> deque = new ArrayDeque<>();

        int index = 0;

        for(int i = 0; i<n; i++)        // i = o to 7
        {
            // 1. Window ke bahar wale index ko remove karo
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) // (F), (T && 0<=1-3)!, (T && 1<2-3)!, (T && 1<=3-3)!, 
            {
                deque.pollFirst();
            }

            // 2. Current number se chhote numbers hatao
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])  // (F), (T && 1<=3), (T && 3<=-1)!, (T&& -1<=-3)!
            {
                deque.pollLast();       // [empty], 
            }

            // 3. Current index add karo
            deque.offerLast(i);     // [0], [1], [1,2], [1,2,3]

            // 4. Window complete ho gayi to maximum store karo
            if(i >= k-1)        // (0>2)!, (1>2)!, (2>=2), (3>=2)
            {
                result[index] = nums[deque.peekFirst()];  // [[0]=3]3, [[1]=3]3
                index++;    // 1, 2
            }
        }
        return result;

    }
}