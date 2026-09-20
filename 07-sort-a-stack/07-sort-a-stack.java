class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        // base case
        if(st.isEmpty())
        {
            return;
        }
        
        int top = st.pop();
        
        // Sort remaining stack
        sortStack(st);
        
        // Insert removed element at its correct position 
        insert(st, top);
        
    }
    
    public void insert(Stack<Integer> s, int topVal)
    {
        // If stack is empty OR top element is smaller/equal to value
        if(s.isEmpty() || s.peek() <= topVal)
        {
            s.push(topVal);
            return;
        }
        
        int top = s.pop();
        
        insert(s, topVal);
        
        s.push(top);
    }
}
