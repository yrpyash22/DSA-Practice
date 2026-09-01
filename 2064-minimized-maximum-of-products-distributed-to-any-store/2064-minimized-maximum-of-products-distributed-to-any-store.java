class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        
        // Input: n = 6, quantities = [11,6]
        int start = 1;
        int end = 0;

        for(int q : quantities)  // 11, 6
        {
            end = Math.max(end, q);     //[0=(0,11)]11, [11=(11,6)]11
        }

        int ans = end;      // 11

        while(start <= end)         // (1<=11), (1<5)
        {
            int mid = (start + end)/2;      // 6, 3

            int stores = 0;


            for(int i = 0; i<quantities.length; i++)        // 0, 1
            {
                // Kitne stores chahiye?
                stores = stores + (quantities[i] + mid -1) / mid;   // [0+(11+6-1)/6]2.6, [2.6+(6+6-1)/6]4.4  | 
            }

            if(stores <= n)     // (4.4<=6)
            {
                // mid possible hai
                ans = mid;          // [6]
                // aur chhota answer try karte hai 
                end = mid - 1;      // [5]
            }
            else{
                // mid possible nahi hai
                start = mid + 1;     
            }
        }
        return ans;
    }
}