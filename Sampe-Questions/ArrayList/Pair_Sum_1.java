package ArrayList;

import java.util.ArrayList;

public class Pair_Sum_1 {
    

    public static boolean pairSum1(ArrayList<Integer> list, int  target)
    {
        for(int i = 0; i< list.size(); i++)
        {
            for(int j = i+1; j <list.size(); j++)
            {
                if(list.get(i) + list.get(j) == target)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean printSum1Pointer(ArrayList<Integer> list, int t)
    {
        int leftP = 0;
        int rightP = list.size() - 1;

        while (leftP != rightP)
        {
            if(list.get(leftP) + list.get(rightP) == t)
            {
                return true;
            }

            if(list.get(leftP) + list.get(rightP) < t)
            {
                leftP++;
            }
            else{
                rightP--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int targat = 5;
        System.out.println(pairSum1(list, targat));
        System.out.println(printSum1Pointer(list, targat));
    }
}
