<h2>M-Coloring Problem</h2><h3>Medium</h3><hr>

<p>You are given an undirected graph consisting of <code>V</code> vertices and <code>E</code> edges represented by a list <code>edges[][]</code>, along with an integer <code>m</code>. Your task is to find if it is possible to color the graph using at most <code>m</code> different colors such that no two adjacent vertices share the same color.</p>

<p><strong>Note:</strong> The graph is indexed with 0-based indexing.</p>

<p>&nbsp;</p>

<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> V = 4, edges[][] = [[0,1],[1,3],[2,3],[3,0],[0,2]], m = 3
<strong>Output:</strong> true
<strong>Explanation:</strong> It is possible to color the graph using 3 colors.

One possible coloring is:

Vertex 0 -> Color 1
Vertex 1 -> Color 2
Vertex 2 -> Color 2
Vertex 3 -> Color 3

No two adjacent vertices have the same color.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> V = 3, edges[][] = [[0,1],[1,2],[0,2]], m = 2
<strong>Output:</strong> false
<strong>Explanation:</strong> It is not possible to color the graph using only 2 colors
because vertices 0, 1, and 2 form a triangle.

Every vertex of the triangle is connected to the other two vertices,
so 3 different colors are required.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> V = 4, edges[][] = [[0,1],[1,2],[2,3]], m = 2
<strong>Output:</strong> true
<strong>Explanation:</strong> One possible coloring is:

Vertex 0 -> Color 1
Vertex 1 -> Color 2
Vertex 2 -> Color 1
Vertex 3 -> Color 2

Adjacent vertices have different colors, so 2 colors are enough.
</pre>

<p>&nbsp;</p>

<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= V &lt;= 10</code></li>
	<li><code>1 &lt;= E &lt;= V * (V - 1) / 2</code></li>
	<li><code>0 &lt;= edges[i][0], edges[i][1] &lt; V</code></li>
	<li><code>1 &lt;= m &lt;= V</code></li>
</ul>

<p>&nbsp;</p>

<h3>Approach</h3>

<p>We can solve this problem using <strong>Backtracking</strong>.</p>

<p>We try to assign a color to each vertex one by one. Before assigning a color, we check whether that color is safe for the current vertex.</p>

<p>A color is safe if none of the adjacent vertices already has the same color.</p>

<p>If a valid color is found, we assign it and move to the next vertex. If no color is possible, we backtrack and change the color of the previous vertex.</p>

<p>The process continues until all vertices are colored successfully or all possible combinations have been tried.</p>

<h3>Java Solution</h3>

<pre>
class Solution {

    public boolean graphColoring(int V, int[][] edges, int m) {

        int[] color = new int[V];

        return solve(0, V, edges, m, color);
    }

    public boolean solve(int vertex, int V, int[][] edges,
                         int m, int[] color) {

        // All vertices are colored
        if (vertex == V) {
            return true;
        }

        // Try every color
        for (int c = 1; c &lt;= m; c++) {

            if (isSafe(vertex, c, edges, color)) {

                // Assign color
                color[vertex] = c;

                // Move to next vertex
                if (solve(vertex + 1, V, edges, m, color)) {
                    return true;
                }

                // Backtrack
                color[vertex] = 0;
            }
        }

        return false;
    }

    public boolean isSafe(int vertex, int c,
                          int[][] edges, int[] color) {

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            if (u == vertex && color[v] == c) {
                return false;
            }

            if (v == vertex && color[u] == c) {
                return false;
            }
        }

        return true;
    }
}
</pre>

<h3>Dry Run</h3>

<pre>
V = 3
edges = [[0,1],[1,2],[0,2]]
m = 2

Graph:

    0
   / \
  1---2
</pre>

<pre>
Vertex 0:

Color 1 -> Safe
color[0] = 1

Vertex 1:

Color 1 -> Not Safe
because vertex 0 already has color 1.

Color 2 -> Safe
color[1] = 2

Vertex 2:

Color 1 -> Not Safe
because vertex 0 has color 1.

Color 2 -> Not Safe
because vertex 1 has color 2.

No color is possible for vertex 2.

So we backtrack.
</pre>

<pre>
After backtracking, no other valid coloring
is possible using only 2 colors.

Therefore:

Output = false
</pre>

<h3>Complexity</h3>

<ul>
	<li><strong>Time Complexity:</strong> <code>O(m<sup>V</sup> * E)</code></li>
	<li><strong>Space Complexity:</strong> <code>O(V)</code></li>
</ul>

