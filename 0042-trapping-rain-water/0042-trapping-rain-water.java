class Solution {
    public int trap(int[] height) {
        // Ex => height = [0,1,0,2,1,0,1,3,2,1,2,1]
        
        int left = 0;
        int right = height.length - 1;      // 11

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while(left <= right) // (0<=11), (1<11), (2<11), (3<11), (3<10)....
        {
            // check leftside boundry
            if(height[left] <= height[right])  // (0<1), (1<=1), (0<1), (2<=1)!
            {
                if(height[left] >= leftMax)     // (0>=0), (1>0), (0>1)!
                {
                    leftMax = height[left];     // [0=0], [0=1], 
                }
                else{
                    water = water + leftMax - height[left];     // [0=0+1-0]1
                }
                left++; // 1, 2, 3
            }
            else{ // // check rightside boundry
                if(height[right] >= rightMax)      // (1>0)
                {
                    rightMax = height[right];       // [0=1]1
                }
                else{
                    water = water + rightMax - height[right];
                }
                right--;            // 10
            }
        }
        return water;
    }
}