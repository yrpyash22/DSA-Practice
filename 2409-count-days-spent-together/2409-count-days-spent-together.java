class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        // Input: arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19"

        int start = Math.max(getDate(arriveAlice), getDate(arriveBob));   // (227, 228)
        int end = Math.min(getDate(leaveAlice), getDate(leaveBob));       // (230, 231)

        if(start > end)   // (228 > 230)!
        {
            return 0;
        }

        return (int) (end - start +1);     // (230-228+1)3
    }

    public static int getDate(String str)
    {
        int lastDate[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int month = Integer.parseInt(str.substring(0, 2));   //(08)
        int day = Integer.parseInt(str.substring(3, 5));     //(15)

        for(int i =0; i< month -1; i++)
        {
            day = day + lastDate[i];                    // [15+31]46, .. 227
        }
        return day;
    }
}