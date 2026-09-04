package Recursion;

public class Friend_paring_problem {
    

    public static int friendPairs(int n)
    {
        if(n == 1 || n == 2)
        {
            return n;
        }

        // Choise of friends
        // single choice
        int fnm1 = friendPairs(n - 1);

        // pair choice
        int fnm2 = friendPairs(n - 2);
        int pairWay = (n - 1) * fnm2;

        int totalWay = fnm1 + pairWay;
        return totalWay;
    }

    public static void main(String[] args) {
        int friend = 4;

        System.out.println("Number of way : "+ friendPairs(friend));
    }
}
