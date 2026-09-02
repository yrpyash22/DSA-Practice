class Solution {
  public boolean graphColoring(int V, int[][] edges, int m){
    
    int color[] = new int[V];
    return solve(O, V, edges, m, color);
  }

  public boolean solve(int vertex, int V, int edges[][], int m, int color[])
  {
    // All vertices are colored
    if(vertex == V)
    {
      return true;
    }

    // Try every color
    for(int i = 1; i <= m; i++)
    {
      // Check if color can be assigned
      if(isSafe(vertex, i, edges, color))
      {
        // Assign color
        color[vertex] = i;

        // Color next vertex
        if (solve(vertex + 1, V, edges, m, color))
        {
          return true;
        }

        // Backtracking
        color[vertex] = 0;
      } 
      
    }
    return false;
  }


  public boolean isSafe(int vertex, int c, int edges[][], int color[])
  {
    for (int edge[] : edges)
    {
      int u = edge[0];
      int v = edge[1];

      if (u == vertex && color[v] == c)
      {
        return false;
      }
      if (v == vertex && color[u] == c)
      {
        return false;
      }
    }
    return true;
  }
  
}
