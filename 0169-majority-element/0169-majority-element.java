class Solution {
    public int majorityElement(int[] nums) {
        int values = 0;
        int count = 0;
        
        for(int i = 0; i< nums.length; i++)
        {
            if(count == 0)
            {
                values = nums[i];
            }

            if(nums[i] == values)
            {
                count++;
            }else{
                count--;
            }
        }
        return values;
    }
}