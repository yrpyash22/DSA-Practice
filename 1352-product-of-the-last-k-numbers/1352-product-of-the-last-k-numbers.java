class ProductOfNumbers {

    ArrayList<Integer> pref;   

    public ProductOfNumbers() {
        pref = new ArrayList<>();
        pref.add(1);
    }
    
    public void add(int num) {
        if(num == 0)
        {
            pref.clear();
            pref.add(1);
        }
        else{
            int product = pref.get(pref.size() - 1) * num;
            pref.add(product);
        }
    }
    
    public int getProduct(int k) {
        int n = pref.size();
        if(k>=n)
        {
            return 0;
        }
        return pref.get(n -1) / pref.get(n -1 -k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */