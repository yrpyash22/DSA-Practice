<h2>Count Inversions</h2>
<h3>Medium</h3>
<hr>

<p>
In an array, two elements <code>arr[i]</code> and <code>arr[j]</code> form an inversion if
<code>i &lt; j</code> and <code>arr[i] &gt; arr[j]</code>.
In other words, the elements are considered to be "out of order".
</p>

<p>
To correct an inversion, we can swap adjacent elements.
Given an array <code>arr</code>, return the total number of inversions required to sort the array.
</p>

<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,1,1,2,2]
<strong>Output:</strong> 0
<strong>Explanation:</strong> The array is already sorted, so there are no inversions.
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [2,1,3,1,2]
<strong>Output:</strong> 4
<strong>Explanation:</strong> The inversions are (2,1), (2,1), (3,1), and (3,2).
Therefore, the total number of inversions is 4.
</pre>

<p>&nbsp;</p>

<p><strong>Function Description</strong></p>

<p>
Complete the function <em>countInversions</em> in the editor below.
</p>

<p>
countInversions has the following parameter:
</p>

<ul>
	<li><code>int arr[n]</code>: an array of integers to sort</li>
</ul>

<p><strong>Returns</strong></p>

<ul>
	<li><code>long</code>: the number of inversions</li>
</ul>

<p><strong>Input Format</strong></p>

<p>
The first line contains an integer <code>t</code>, the number of datasets.
</p>

<p>
Each of the next <code>t</code> pairs of lines contains:
</p>

<ol>
	<li>The first line contains an integer <code>n</code>, the number of elements in the array.</li>
	<li>The second line contains <code>n</code> space-separated integers representing the array.</li>
</ol>

<p><strong>Sample Input</strong></p>

<pre>
2
5
1 1 1 2 2
5
2 1 3 1 2
</pre>

<p><strong>Sample Output</strong></p>

<pre>
0
4
</pre>

<p><strong>Explanation</strong></p>

<p>
For the first dataset, the array is already sorted, so there are no inversions.
</p>

<p>
For the second dataset:
</p>

<pre>
arr = [2,1,3,1,2]
</pre>

<p>
The inversions are:
</p>

<pre>
(2,1)
(2,1)
(3,1)
(3,2)
</pre>

<p>
Therefore, we need a total of <strong>4</strong> adjacent swaps to sort the array.
</p>

<p>&nbsp;</p>

<p><strong>Approach:</strong></p>

<p>
We use the <strong>Merge Sort</strong> algorithm to count inversions efficiently.
During the merge step, if an element from the right half is smaller than an element from the left half, then it forms an inversion with all the remaining elements in the left half.
</p>

<p>
The number of inversions can be calculated using:
</p>

<pre>
count += (mid - i + 1);
</pre>

<p>
This allows us to count multiple inversions at once instead of checking every pair individually.
</p>

<p><strong>Complexity:</strong></p>

<ul>
	<li><strong>Time Complexity:</strong> O(n log n)</li>
	<li><strong>Space Complexity:</strong> O(n)</li>
</ul>

<p>&nbsp;</p>

<p><strong>Key Concept:</strong></p>

<p>
If the left half is:
</p>

<pre>
[2,5,7]
</pre>

<p>
and the right half contains:
</p>

<pre>
[1,6]
</pre>

<p>
When <code>1</code> is smaller than <code>2</code>, it is also smaller than <code>5</code> and <code>7</code>.
Therefore, it creates three inversions:
</p>

<pre>
(2,1)
(5,1)
(7,1)
</pre>

<p>
Instead of counting them one by one, we add all three using:
</p>

<pre>
count += (mid - i + 1);
</pre>
