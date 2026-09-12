package ArrayList;

import java.util.ArrayList;

public class  Maximum_in_array {
    
    public static int maxValue(ArrayList<Integer> list)
    {
        int max = Integer.MIN_VALUE;
        for(int i =0; i<list.size(); i++)
        {
            if(max < list.get(i))
            {
                max = list.get(i);
            }
        }
        return max;
    } 

    public static void main(String[] args) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(5);
        arr.add(9);
        arr.add(3);
        arr.add(6);
        System.out.println(maxValue(arr));
    }
}
