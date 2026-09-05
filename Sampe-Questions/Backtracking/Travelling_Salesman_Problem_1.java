package Backtracking;


// This problem is solve in Backtracking (DFS) concept
public class Travelling_Salesman_Problem_1 {

    static int n;
    static int finalCost = Integer.MAX_VALUE;
    
    public static int tsp(int graph[][])
    {
        n = graph.length;

        boolean visited[] = new boolean[n];

        // Starting city
        visited[0] = true;

        solve(graph, 0, 1, 0, visited);

        return finalCost;
    }


    public static void solve(int graph[][], int curr, int count, int cost, boolean visited[])
    {
        // Sabhi cities visit ho gayi (Base Case)
        if(count == n)
        {
            // Last city se starting city par wapas
            if(graph[curr][0] != 0)
            {
                int totalCost = cost + graph[curr][0];

                finalCost = Math.min(finalCost, totalCost);
            }

            return;
        }


        // Har city ko try karo
        for(int city = 0; city < n; city++)
        {
            // City visit nahi hui aur edge exist karta hai
            if(!visited[city] && graph[curr][city] != 0)
            {
                // Branch
                visited[city] = true;

                // Recursion
                solve(graph, city, count +1, cost + graph[curr][city], visited);

                // Backtracking
                visited[city] = false;
            }
        }
    }


    public static void main(String[] args) {
        
        int graph[][] = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        System.out.println("Minimum Cost = " + tsp(graph));
    }
}
