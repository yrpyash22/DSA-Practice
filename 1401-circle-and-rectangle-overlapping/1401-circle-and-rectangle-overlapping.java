class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        
        // Input:   radius = 1,  xCenter = 0,  yCenter = 0,    x1 = 1, y1 = -1, x2 = 3, y2 = 1

        int closestX = Math.max(x1, Math.min(xCenter, x2));    // [(1,(0,3))]1, 
        int closestY = Math.max(y1, Math.min(yCenter, y2));    // [(-1,(0,1))]0,

        int dx = closestX - xCenter;     // [1-0]1
        int dy = closestY - yCenter;     // [0-0]0

        int disSquare = dx * dx + dy * dy;     // [1*1+0*0]1
        int radSquare = radius * radius;   // [1*1]1
        return  disSquare <= radSquare;     //(1<=1)T
    }
}