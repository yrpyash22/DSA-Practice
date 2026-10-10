// class Solution {
//     public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

//         // Input: nums1 = [1,4,10,12], nums2 = [5,8,6,9], k1 = 1, k2 = 1

//         int n = nums1.length;        // 4
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

//         for (int i = 0; i < n; i++)        // 0, 1, 2, 3
//         {
//             pq.add(Math.abs(nums1[i] - nums2[i]));  // [4], [4,4], [4,4,4], [4,4,4,3]
//         }

//         long k =  (long) k1 + k2;          // [1+1]2

//         while(k > 0 && pq.peek() > 0)    // (2>0 && 4>0), (1>0 && 4>0), (0>0 && 4>0)!
//         {
//             int diff = pq.poll();    // 4, 4
//             pq.add(diff - 1);        // [4,4,3,3], [4,3,3,3]
//             k--;                     // 1 , 0
//         }
        
//         long ans = 0;

//         while (!pq.isEmpty())          // (T), (T), (T), (T), (F)
//         {
//             long diff = pq.poll();       // 4, 3, 3, 3
//             ans = ans + diff * diff;     // [0+4*4]16, [16+3*3]25, [25+3*3]34, [34+3*3]43 
//         }

//         return ans;          // 43
//     }
// }



class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long diff[] = new long[n];

        long sum = 0;
        long max = 0;

        for (int i = 0; i < n; i++)
        {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum = sum + diff[i];
            max = Math.max(max, diff[i]);
        }

        long k = (long) k1 + k2;

        if(k >= sum)
        {
            return 0;
        }

        long left = 0, right = max;

        while (left < right) {
            long mid = (left + right) / 2;
            long needed = 0;

            for(long d : diff)
            {
                if (d > mid)
                {
                    needed = needed + d - mid;
                }
            }

            if (needed <= k)
            {
                right = mid;
            } 
            else {
                left = mid + 1;
            }
        }

        long remaining = k;

        for (int i = 0; i < n; i++)
        {
            long reduction = Math.max(0, diff[i] - left);
            diff[i] -= reduction;
            remaining -= reduction;
        }

        // Use remaining operations to reduce values at the threshold.
        for (int i = 0; i < n && remaining > 0; i++)
        {
            if (diff[i] == left && diff[i] > 0) {
                diff[i]--;
                remaining--;
            }
        }

        long answer = 0;

        for (long d : diff) {
            answer += d * d;
        }

        return answer;
    }
}

