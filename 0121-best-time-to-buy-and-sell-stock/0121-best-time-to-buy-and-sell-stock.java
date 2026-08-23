class Solution {
    public int maxProfit(int[] prices) {
        int buy_price = Integer.MAX_VALUE; // + infinite
        int max_profit = 0;

        for(int i = 0; i < prices.length; i++)
        {
            if(buy_price < prices[i]) // (M,7), (7,1), (1,5), (1,3), (1,6), (1,4)
            {
                int profit = prices[i] - buy_price;        // 4, 2, 5, 3
                max_profit = Math.max(max_profit, profit); // 4, 4, 5, 5
            }else{
                buy_price = prices[i];   // 7, 1
            }
        }
        return max_profit;   // 5
    }
}