package ArrayList;

import java.util.ArrayList;

public class Pair_Sum_2 {
    

    public static boolean printSum2(ArrayList<Integer> list, int t)
    {
        int start = -1;
        int end = list.size();

        for(int i = 0; i<end; i++)
        {
            // Find position of pivot
            if(list.get(i) > list.get(i + 1))
            {
                start = i;
                break;
            }
        }

        int leftP = start + 1;   // pivot + 1
        int rightP = start;      // pivot

        while (leftP != rightP)
        {
            if(list.get(leftP) + list.get(rightP) == t)
            {
                System.out.println("Pair is: ("+ list.get(leftP) +"," + list.get(rightP) +")");
                return true;
            }

            if(list.get(leftP) + list.get(rightP) < t)
            {
                leftP = (leftP + 1) % end;
            }
            else{
                rightP = (end + rightP - 1) % end;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int targat = 14;

        System.out.println(printSum2(list, targat));
    }

}
