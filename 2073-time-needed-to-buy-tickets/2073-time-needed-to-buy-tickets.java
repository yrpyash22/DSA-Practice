class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        // Input: tickets = [2,3,2], k = 2       dry run
        
        Queue<Integer> q = new LinkedList<>();

        // in this we add person index
        for(int i = 0; i < tickets.length; i++)         // 0,1,2
        {
            q.add(i);       // [0,1,2]
        }

        int time = 0;

        while(!q.isEmpty())  //(T), (T), (T), (T), (T)
        {
            int person = q.remove();  // 0, 1, 2, 0, 1, 2

            tickets[person]--;        // [0]{1}, [1]{2}, [2]{1}, [0]{0}, [1]{1}, [2]{0}
            time++;                   // 1, 2, 3, 4, 5, 6

            // agar k bale person ke ticket complete ho jaye
            if(person == k && tickets[person] == 0)         //(0=2 & 1=0)!, (1=2&)!, (2==2& 1=0)!, (0=2&)!, (1=2&)!, (2==2 & 0==0)
            {
                return time;    // 6
            }

            if(tickets[person] > 0)    // (1>0), (2>0), (1>0), (0>0)!, (1>0)
            {
                q.add(person);      // [1,2,0], [2,0,1], [0,1,2], [2,1]
            }
        }
        return time;
    }
}