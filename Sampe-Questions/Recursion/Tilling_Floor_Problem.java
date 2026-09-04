package Recursion;

public class Tilling_Floor_Problem {

    public static int tillingProblem(int n)
    {
        // baseCase
        if(n == 0 || n ==1 )
        {
            return 1;
        }

        // Work
        // [1] Vertical Choice
        int fnm1 = tillingProblem(n - 1);
        // [2] Horizental Choice
        int fnm2 = tillingProblem(n - 2);

        int totalWay = fnm1 + fnm2;
        return totalWay;
    }


    public static void main(String[] args) {
        int n = 4;
        System.out.println(tillingProblem(n));
    }
}
