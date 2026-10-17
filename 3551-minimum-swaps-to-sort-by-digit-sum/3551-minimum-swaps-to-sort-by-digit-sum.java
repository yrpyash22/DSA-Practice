class Solution {
    public int minSwaps(int[] nums) {

        // Input: nums = [18, 43, 34, 16]

        int n = nums.length;     // 4
        int swap = 0;

        // Store numbers with their digit sums
        int[][] arr = new int[n][2];

        for(int i =0; i<n; i++)     // 0,1,2,3
        {
            int sum = 0;
            int val = nums[i];

            while(val > 0)
            {
                sum = sum + val % 10;
                val = val / 10;
            }
            arr[i][0] = nums[i];
            arr[i][1] = sum;
        } 

        // arr[][] = {{18, 9}, {43, 7}, {34, 7}, {16, 7}}


        // Sort by digit sum, then by number
        Arrays.sort(arr, (a, b) -> {      // (a = {arr[i][0], arr[i][1]}, b = {arr[i+1][0], arr[i+1][1]})
            if(a[1] != b[1])   // (9 != 7)
            {
                return a[1] - b[1];    // 2, 
            }
            return a[0] - b[0];     // [43-34]9, [34-16]18
        });   
        // arr[][] = {{16, 7}, {34, 7}, {43, 7}, {18, 9}}



        // Store original positions
        Map<Integer, Integer> pos = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            pos.put(nums[i], i);
        }
        // pos = {18=0, 43=1, 34=2, 16=3}


        // count swaping min
        for(int i = 0; i < n; i++)   // 0, 1, 2, 3
        {
            int correct = arr[i][0];   // 16, 34, 43, 18

            if(nums[i] != correct)  // (18!=16), (43!=34), (43!=43)!, (18!=18)!
            {
                int j = pos.get(correct);  // 3, 2

                pos.put(nums[i], j);   // (18, 3), (43, 2)
                pos.put(correct, i);   // (16, 0), (34, 1)

                int temp = nums[i];    // 18, 43
                nums[i] = nums[j];     // 16, 34
                nums[j] = temp;        // 18, 43
                // Arr [16, 43, 34, 18],  [16, 34, 43, 18], 

                swap++;     // 1, 2
            }
        }
        return swap;
    }
}
