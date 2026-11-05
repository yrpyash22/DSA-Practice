class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        // Input: arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2

        int count = 0;
        for(int arrL : arr1)        // 4, 5, 8
        {
            boolean valid = true;   // T, T, T
            for(int arrR : arr2)    // 10 , 9, 1 , 8
            {
                int val = Math.abs(arrL - arrR);   // 6,5,3,4 | 5,4,4,3 | 2,1,7,0
                if(val <= d)   // (6<=2)! ,... , (2<=2), (1<=2), (7<=2)!, (0<=2)
                {
                    valid = false;  // F
                    break;
                }
            }
            if(valid)   // T, T
            {
                count++;   // 1, 2
            }
        }
        return count;    // 2
    }
}