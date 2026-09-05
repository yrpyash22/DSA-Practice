package Backtracking;

public class Hamiltanion_Cycle {
    

    public static boolean hamCycle(int graph[][])
    {
        int n = graph.length;

        int path[] = new int[n];

        // Sabhi vertices ko initially -1
        for(int i = 0; i < n; i++)
        {
            path[i] = -1;
        }

        // Starting vertix
        path[0] = 0;

        // Recursion + backtracking
        if(solve(graph, path, 1))
        {
            return true;
        }

        return false;
    }


    public static boolean solve(int garph[][], int path[], int pos)
    {
        // Base case
        // Sabhi vertices path mein aa gaye
        if(pos == garph.length)
        {
            // Last vertex se starting vertex ka edge hona chahiye
            if(garph[path[pos -1]][path[0]] == 1)
            {
                return true;
            }
            
            return false;
        }

        // Har vertex ko try karo
        for(int vertix = 1; vertix<garph.length; vertix++)
        {
            // Check karo ki vertex valid hai ya nahi
            if(isSafe(vertix, garph, path, pos))
            {
                // Choose
                path[pos] = vertix;

                // Recursion
                if(solve(garph, path, pos + 1))
                {
                    return true;
                }

                // Backtracking
                path[pos] = -1;
            }
        }
        return false;
    }


    public static boolean isSafe(int v, int graph[][], int path[], int pos)
    {
        // Previous vertex se edge hona chahiye
        if(graph[path[pos -1]][v] == 0)
        {
            return false;
        } 

        // Vertex already visited nahi hona chahiye
        for (int i = 0; i < pos; i++)
        {
            if(path[i] == v)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int graph[][] = {
            {0, 1, 0, 1}, 
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };

        System.out.println(hamCycle(graph));
        
    }
}

/*
0 ───── 1
│       │
│       │
3 ───── 2
*/
