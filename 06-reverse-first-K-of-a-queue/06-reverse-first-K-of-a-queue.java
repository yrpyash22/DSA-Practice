class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
        
        if(k > q.size())
        {
            return q;
        }
        
        Stack<Integer> s = new Stack<>();
        
        for(int i = 1; i<=k; i++)
        {
            s.push(q.remove());
        }
        
        while(!s.isEmpty())
        {
            q.add(s.pop());
        }
        
        int remain = q.size() - k;
        
        for(int i = 0; i<remain; i++)
        {
            q.add(q.remove());
        }
        
        return q;
    }
}
