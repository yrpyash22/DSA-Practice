<h2><a href="https://www.geeksforgeeks.org/problems/the-celebrity-problem/1">The Celebrity Problem</a></h2><h3>Medium</h3><hr><p>You are given a square matrix <code>mat</code> of size <code>n x n</code> representing people at a party. If <code>mat[i][j] == 1</code>, it means person <code>i</code> knows person <code>j</code>.</p>

<p>A <strong>celebrity</strong> is a person who:</p>

<ul>
	<li>Everyone at the party knows the celebrity.</li>
	<li>The celebrity knows no one at the party.</li>
</ul>

<p>Return the index of the celebrity if one exists, otherwise return <code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> mat = [[0,1,0],
             [0,0,0],
             [0,1,0]]

<strong>Output:</strong> 1

<strong>Explanation:</strong> Person 1 is known by everyone, and person 1 does not know anyone.
Therefore, person 1 is the celebrity.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> mat = [[0,1],
             [1,0]]

<strong>Output:</strong> -1

<strong>Explanation:</strong> Both people know each other, so there is no celebrity.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> mat = [[0]]

<strong>Output:</strong> 0

<strong>Explanation:</strong> The only person does not know anyone, and everyone knows that person.
Therefore, person 0 is the celebrity.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= mat.length &lt;= 1000</code></li>
	<li><code>mat.length == mat[i].length</code></li>
	<li><code>mat[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
	<li><code>mat[i][i] == 0</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow-up:&nbsp;</strong>Can you solve the problem in <code>O(n)</code> time complexity?
