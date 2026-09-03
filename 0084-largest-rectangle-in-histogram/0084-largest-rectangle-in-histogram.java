class Solution {
    public int largestRectangleArea(int[] heights) {
        
        // Example = heights = [2,1,5,6,2,3]

        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        int n = heights.length;     // 6

        for(int i = 0; i<= n; i++)  // 0, 1, 2, 3, 4, 5, 6
        {
            int currentHeight;

            if(i == n)      // (0==6)!, (1==6).....! Rare condition
            {
                currentHeight = 0;
            }
            else{
                currentHeight = heights[i];     // [0=h[0]]2, [0=h[1]]1, [0=h[2]]5, [0=h[3]]6, [0=h[4]]2, [0=h[5]]3
            }

            while(!stack.isEmpty() && heights[stack.peek()] > currentHeight)
            {
                int height = heights[stack.pop()];
                int width;

                if(stack.isEmpty()) 
                {
                    width = i;
                }else{
                    width = i - stack.peek() -1;
                }

                int area = height * width;  
                maxArea = Math.max(maxArea, area);      
            }
            stack.push(i);
        }
        return maxArea;
    }
}