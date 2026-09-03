class Solution {
    public int[][] merge(int[][] intervals) {
        // Ex-> [[1,3],[2,6],[8,10],[15,18]]
        // Intervals ko unke starting value ke according ascending order mein sort karo
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); 

        ArrayList<int[]> result = new ArrayList<>();

        int start = intervals[0][0];   // 1
        int end = intervals[0][1];     // 3

        for(int i = 0; i< intervals.length; i++)
        {
            // Overlapping intervals
            if (intervals[i][0] <= end) // (1<=3), (2<=3), (8<=6)!, (15<=10)
            {
                end = Math.max(end, intervals[i][1]); // (3,3), (3,6)
            }
            // Non-overlapping interval
            else {  
                result.add(new int[]{start, end}); // (1,6), (8,10) 

                start = intervals[i][0];    // 8, 15
                end = intervals[i][1];      // 10, 18
            }
        }

        // Add the last interval
        result.add(new int[]{start, end});  // (15,18)
        return result.toArray(new int[result.size()][]);     // size-> [3] {(1,6), (8,10), (15,18)}

    }
}