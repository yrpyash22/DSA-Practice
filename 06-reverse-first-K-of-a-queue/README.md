<h2><a href="https://www.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1">Reverse First K of a Queue</a></h2><h3>Easy</h3><hr><p>Given an integer <code>k</code> and a <a href="https://www.geeksforgeeks.org/queue-data-structure/">queue</a> of integers, reverse the order of the first <code>k</code> elements of the queue, leaving the other elements in the same relative order.</p>

<p>Only the following standard queue operations are allowed:</p>

<ul>
	<li><code>enqueue(x)</code>: Add an item <code>x</code> to the rear of the queue.</li>
	<li><code>dequeue()</code>: Remove an item from the front of the queue.</li>
	<li><code>size()</code>: Returns the number of elements in the queue.</li>
	<li><code>front()</code>: Finds the front item.</li>
</ul>

<p><strong>Note:</strong></p>

<ul>
	<li>The above operations represent the general processings.</li>
	<li>In-built functions of the respective languages can be used to solve the problem.</li>
	<li>If the size of the queue is smaller than the given <code>k</code>, return the original queue.</li>
</ul>

<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> q = [1, 2, 3, 4, 5], k = 3
<strong>Output:</strong> [3, 2, 1, 4, 5]
<strong>Explanation:</strong> After reversing the first 3 elements from the given queue, the resultant queue will be [3, 2, 1, 4, 5].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> q = [4, 3, 2, 1], k = 4
<strong>Output:</strong> [1, 2, 3, 4]
<strong>Explanation:</strong> After reversing the first 4 elements from the given queue, the resultant queue will be [1, 2, 3, 4].
</pre>

<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= q.size() &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= q[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>5</sup></code></li>
</ul>
