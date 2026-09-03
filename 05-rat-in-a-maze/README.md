<h2>Rat in a Maze</h2>
<h3>Medium</h3>
<hr>

<p>
Given a binary matrix <strong>maze[][]</strong> of size <strong>n × n</strong> containing values <strong>0</strong> and <strong>1</strong>, find all possible paths for a rat to travel from the source cell <strong>(0, 0)</strong> to the destination cell <strong>(n - 1, n - 1)</strong>.
</p>

<p>
The rat can move in four directions: <strong>Up (U), Down (D), Left (L), and Right (R)</strong>.
</p>

<ul>
<li><strong>1</strong> represents an open cell through which the rat can move.</li>
<li><strong>0</strong> represents a blocked cell that cannot be traversed.</li>
<li>The rat cannot visit the same cell more than once in a path.</li>
<li>Return all valid paths as strings consisting of <strong>U, D, L, R</strong>.</li>
<li>Return the paths in <strong>lexicographically increasing order</strong>.</li>
<li>If no valid path exists, return an empty list.</li>
</ul>

<p>&nbsp;</p>

<p><strong class="example">Example 1:</strong></p>

<pre>
Input: maze[][] = {
    {1, 0, 0, 0},
    {1, 1, 0, 1},
    {1, 1, 0, 0},
    {0, 1, 1, 1}
}

Output: ["DDRDRR", "DRDDRR"]

Explanation:
There are two valid paths from the source cell (0, 0)
to the destination cell (3, 3).
</pre>

<p>&nbsp;</p>

<p><strong class="example">Example 2:</strong></p>

<pre>
Input: maze[][] = {
    {1, 0},
    {1, 0}
}

Output: []

Explanation:
No path exists because the destination cell (1, 1)
is blocked.
</pre>

<p>&nbsp;</p>

<p><strong class="example">Example 3:</strong></p>

<pre>
Input: maze[][] = {
    {1, 1},
    {1, 1}
}

Output: ["DR", "RD"]

Explanation:
The rat can reach the destination using two paths:
Down → Right
Right → Down
</pre>

<p>&nbsp;</p>

<h3>Constraints</h3>

<ul>
<li>2 ≤ n ≤ 5</li>
<li>0 ≤ maze[i][j] ≤ 1</li>
</ul>

<h3>Approach</h3>

<p>
We use <strong>Backtracking</strong> to explore all possible paths from the source to the destination.
</p>

<ol>
<li>Start from the cell <strong>(0, 0)</strong>.</li>
<li>Check whether the current cell is valid and open.</li>
<li>Mark the current cell as visited so that it is not used again in the same path.</li>
<li>Try moving in all four directions: <strong>D, L, R, U</strong>.</li>
<li>Add the selected direction to the current path.</li>
<li>If the destination is reached, store the path in the answer.</li>
<li>After exploring a direction, backtrack by removing the last direction.</li>
<li>Unmark the current cell so it can be used in another path.</li>
</ol>

<p>
To get the paths in lexicographically increasing order, we explore the directions in the order:
<strong>D → L → R → U</strong>.
</p>


<h3>Dry Run</h3>

<pre>
maze = {
    {1, 1},
    {1, 1}
}

Start = (0,0)

Path = ""

Try Down:
(0,0) → (1,0)
Path = "D"

From (1,0), try Right:
(1,0) → (1,1)
Path = "DR"

Destination reached.
Add "DR".

Backtrack.

Try Right from (0,0):
(0,0) → (0,1)
Path = "R"

From (0,1), try Down:
(0,1) → (1,1)
Path = "RD"

Destination reached.
Add "RD".

Final Answer:
["DR", "RD"]
</pre>

<h3>Complexity</h3>

<ul>
<li><strong>Time Complexity:</strong> O(4<sup>n²</sup>) in the worst case because each cell can have up to four possible directions.</li>
<li><strong>Space Complexity:</strong> O(n²) for the visited matrix and recursion stack.</li>
</ul>

<h3>Key Concept</h3>

<p>
<strong>Backtracking:</strong> Try a possible direction → move to the next cell → explore further → if the path does not work, go back and try another direction.
</p>
