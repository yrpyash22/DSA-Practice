class MinStack {

    // input = ["MinStack","push","push","push","getMin","pop","top","getMin"] 
    //          [[],        [-2],   [0],  [-3],   [],     [],   [],     []]

    Stack<Integer> s;

    // This stack store min values 
    Stack<Integer> minS;

    public MinStack() {
        
        s = new Stack<>();

        minS = new Stack<>();
    }

    
    public void push(int value) {
        
        s.push(value);      // [-2], [-2,0], [-2,0,-3]

        // If minStack is empty OR current value is smaller/equal to current minimum
        if(minS.isEmpty() || value <= minS.peek())   //(T), (F||0<=-2)!, (F|-3<=2)
        {
            minS.push(value);           // [-2], [-2,-3]
        }
    }
    
    public void pop() {
        // If the element being removed is the current minimum
        if(s.peek().equals(minS.peek()))  //(-3==-3)
        {
            minS.pop();    // -3
        }
        s.pop();    // -3
    }
    
    public int top() {
        return s.peek();   // -2, 0
    }
    
    public int getMin() {
        return minS.peek();      // -3, -2
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */