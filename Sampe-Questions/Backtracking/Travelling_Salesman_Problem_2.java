package Backtracking;

// This problem is solve in Branch and bound (BFS) concept
// IN Lower Bound Theory
public class Travelling_Salesman_Problem_2 {

    static int n;
    static int minCost = Integer.MAX_VALUE;
    
    public static void tsp_lbt(int graph[][])
    {
        n = graph.length;

        boolean visited[] = new boolean[n];

        // Starting city
        visited[0] = true;

        solve(graph, 0, 1, 0, visited);

    }


    public static void solve(int graph[][], int curr, int count, int cost, boolean visited[])
    {
        // Sabhi cities visit ho gayi (Base Case)
        if(count == n)
        {
            // Last city -> Starting city
            if(graph[curr][0] != 0) 
            {

                int totalCost = cost + graph[curr][0];

                if(totalCost < minCost) 
                {
                    minCost = totalCost;
                }
            }
            return;
        }


        // Try every city
        for(int city = 0; city < n; city++)
        {
            // City visit nahi hui aur edge exist karta hai
            if(!visited[city] && graph[curr][city] != 0)
            {
                // New cost
                int newCost = cost + graph[curr][city];

                // Lower Bound
                int lowerBound = newCost + bound(graph, visited, city);

                // Pruning
                if(lowerBound >= minCost)
                {
                    continue;
                }

                // Choose
                visited[city] = true;

                // Recursion
                solve(graph, city, count + 1, newCost, visited);

                // Backtracking
                visited[city] = false;
            }
        }
    }

    // Lower Bound
    public static int bound(int graph[][], boolean visited[], int curr)
    {
        int bound = 0;

        // Current city ka minimum edge
        int min = Integer.MAX_VALUE;

        for(int j = 0; j<n; j++)
        {
            if(j != curr && graph[curr][j] != 0)
            {
                min = Math.min(min, graph[curr][j]);
            }
        }

        if(min != Integer.MAX_VALUE)
        {
            bound = bound + min;
        }

        // Unvisited cities ke minimum edges
        for(int i =0; i< n; i++)
        {
            if (!visited[i] && i != curr)
            {
                min = Integer.MAX_VALUE;

                for(int j =0; j<n; j++)
                {
                    if( i != j && graph[i][j] != 0)
                    {
                        min = Math.min(min, graph[i][j]);
                    }
                }

                if (min != Integer.MAX_VALUE)
                {
                    bound = bound + min;
                }
            }
        }
        return bound;
    }


    public static void main(String[] args) {

        int graph[][] = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        tsp_lbt(graph);

        System.out.println("Minimum Cost = " + minCost);
    }
}
