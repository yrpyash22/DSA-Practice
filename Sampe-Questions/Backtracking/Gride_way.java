package Backtracking;

public class Gride_way {
    

    public static int gridWays(int row, int col, int m, int n)
    {
        // Base Case
        if(row == m-1 && col == n-1)
        {
            return 1;
        }
        else if(row == m || col == n)
        {
            return 0;
        }

        int w1 = gridWays(row +1, col, m, n);
        int w2 = gridWays(row, col +1, m, n);
        return w1 + w2;
    }  // 2(n+m)


    public static long gridWays_trick(int m, int n)
    {
        int total = m + n -2;
        int r = Math.min(m-1, n-1);

        long ans = 1;

        for(int i = 1; i<=r; i++)
        {
            ans = ans * (total - r + i)/i;
        }

        return ans;
    }   // O(1)



    public static void main(String[] args) {
        int m = 3;
        int n = 3;

        System.out.println(gridWays(0, 0,m, n));
        System.out.println(gridWays_trick(m, n));
    }
}
