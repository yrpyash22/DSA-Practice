class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        int total = numBottles;

        while(numBottles >= numExchange)
        {
            int newBottle = numBottles/numExchange;

            total = total + newBottle;

            numBottles = (numBottles % numExchange) + newBottle;
        }
        return total;
    }
}