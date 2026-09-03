class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            // Input: nums1 = [1,2], nums2 = [3,4]
        // Binary search smaller array par karenge
        if (nums1.length > nums2.length) // (2>2)!
        {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;       // 2
        int n = nums2.length;       // 2

        int start = 0;
        int end = m;        // 2

        while (start <= end)        // (0<=2)
        {

            // nums1 ka partition
            int pt1 = (start + end)/ 2;     // 1

            // nums2 ka partition
            int pt2 = (m + n + 1) / 2 - pt1;        // [1.5]1


            // nums1 ke left ka maximum
            int left1;
            if(pt1 == 0) 
            {
                left1 = Integer.MIN_VALUE;
            }
            else{
                left1 = nums1[pt1 - 1];     // [1]
            }


            // nums1 ke right ka minimum
            int right1;
            if (pt1 == m) 
            {
                right1 = Integer.MAX_VALUE;
            } 
            else {
                right1 = nums1[pt1];        // [2]
            }


            // nums2 ke left ka maximum
            int left2;
            if (pt2 == 0) 
            {
                left2 = Integer.MIN_VALUE;
            } 
            else {
                left2 = nums2[pt2 - 1];     // [3]
            }


            // nums2 ke right ka minimum
            int right2;
            if (pt2 == n) 
            {
                right2 = Integer.MAX_VALUE;
            } 
            else {
                right2 = nums2[pt2];        // [4]
            }


            // Correct partition
            if (left1 <= right2 && left2 <= right1) // (1<2 && 3<4)
            {
                // Total elements odd
                if ((m + n) % 2 == 1)           // (4%2==1)!
                {
                    return Math.max(left1, left2);
                }

                // Total elements even
                int leftMax = Math.max(left1, left2);       // [3]
                int rightMin = Math.min(right1, right2);    // [2]

                return (leftMax + rightMin) / 2.0;      // [2.5]
            }
            // nums1 ka partition bahut right hai
            else if (left1 > right2) 
            {
                end = pt1 - 1;
            }
            // nums1 ka partition bahut left hai
            else {
                start = pt1 + 1;
            }
        }
        return 0.0;
    }
}