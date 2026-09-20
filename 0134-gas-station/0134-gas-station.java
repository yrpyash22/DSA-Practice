class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        // Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]

        int totalGas = 0;
        int totalCost = 0;

        int start = 0;
        int tank = 0;

        for(int i =0; i<gas.length; i++)            // 0,1,2,3,5
        {
            totalGas = totalGas + gas[i];          // 1, 3, 6, 10, 15
            totalCost = totalCost + cost[i];       // 3, 7, 12, 13, 15

            // Gas available after travelling to next station
            tank = tank + gas[i] - cost[i];         // -2, -2, -2, 3, 3

            if(tank < 0)        //(-2<0),(-2<0),(-2<0), (3<0)!, (3<0)!
            {
                start = i+ 1;       // 1, 2, 3
                tank = 0;
            }
        }

        // If total gas is less than total cost, completing the circuit is impossible
        if(totalGas < totalCost)   // (15<15)!
        {
            return -1;
        }
        return start;       // 3
    }
}