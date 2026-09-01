<h2>Painter's Partition</h2><h3>Medium</h3><hr>

<p>There is a fence which consists of <code>n</code> wooden blocks, with each block having a number written on it, represented by an array <code>arr</code>. The painter is also given a number <code>k</code>, representing the maximum number of painters available.</p>

<p>The painter has to paint the fence following these conditions:</p>

<ul>
	<li>He has to paint the fence in sequential manner from left to right, i.e., first paint the first block, then the second block and so on without leaving any block unpainted.</li>
	<li>The blocks assigned to each painter must be contiguous.</li>
	<li>A painter can paint any number of consecutive blocks.</li>
	<li>A block cannot be split between two painters.</li>
	<li>The goal is to divide the blocks among at most <code>k</code> painters such that the maximum sum of numbers assigned to any painter is as small as possible.</li>
</ul>

<p>Return the minimum possible maximum sum of blocks assigned to a painter.</p>

<p>&nbsp;</p>

<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [10,20,30,40], k = 2
<strong>Output:</strong> 60
<strong>Explanation:</strong> One optimal way is:
Painter 1 -> [10,20,30] = 60
Painter 2 -> [40] = 40

The maximum sum is max(60,40) = 60.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [10,20,30,40,50], k = 3
<strong>Output:</strong> 60
<strong>Explanation:</strong> One optimal way is:
Painter 1 -> [10,20,30] = 60
Painter 2 -> [40] = 40
Painter 3 -> [50] = 50

The maximum sum is max(60,40,50) = 60.
</pre>

<p>&nbsp;</p>

<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 10<sup>5</sup></li>
	<li><code>1 &lt;= k &lt;= arr.length</code></li>
	<li><code>1 &lt;= arr[i] &lt;= 10<sup>6</sup></code></li>
</ul>

<p>&nbsp;</p>

<h3>Approach</h3>

<p>We can solve this problem using <strong>Binary Search on Answer</strong>.</p>

<p>The minimum possible answer is the maximum element of the array because a painter must paint that complete block.</p>

<p>The maximum possible answer is the sum of all elements, when one painter paints the entire fence.</p>

<p>Therefore, our binary search range is:</p>

<pre>
<strong>start:</strong> maximum element in arr
<strong>end:</strong> sum of all elements in arr
</pre>

<p>For every <code>mid</code>, we check whether it is possible to divide the fence among at most <code>k</code> painters such that no painter gets a sum greater than <code>mid</code>.</p>

<p>If it is possible, we try to find a smaller answer. Otherwise, we increase the maximum allowed sum.</p>

<h3>Java Solution</h3>

<pre>
class Solution {

    public int painterPartition(int[] arr, int k) {

        int start = 0;
        int end = 0;

        // Find maximum element and total sum
        for (int value : arr) {
            start = Math.max(start, value);
            end += value;
        }

        int answer = end;

        while (start &lt;= end) {

            int mid = start + (end - start) / 2;

            if (canPaint(arr, k, mid)) {

                // mid is possible
                answer = mid;

                // Try for a smaller answer
                end = mid - 1;

            } else {

                // mid is not possible
                start = mid + 1;
            }
        }

        return answer;
    }

    public boolean canPaint(int[] arr, int k, int maxSum) {

        int painters = 1;
        int currentSum = 0;

        for (int value : arr) {

            if (currentSum + value &lt;= maxSum) {

                currentSum += value;

            } else {

                // Assign this block to a new painter
                painters++;
                currentSum = value;
            }
        }

        return painters &lt;= k;
    }
}
</pre>

<h3>Dry Run</h3>

<pre>
arr = [10,20,30,40]
k = 2

start = 40
end = 100

mid = 70

Painter 1 -> 10 + 20 + 30 = 60
Painter 2 -> 40

2 painters are enough.

So, 70 is possible.
Try a smaller value.

end = 69
</pre>

<pre>
mid = 54

Painter 1 -> 10 + 20 = 30
Painter 2 -> 30
Painter 3 -> 40

3 painters are required.

But k = 2.

So, 54 is not possible.

start = 55
</pre>

<p>Binary search continues until the minimum possible maximum sum is found.</p>

<pre>
Answer = 60
</pre>

<h3>Complexity</h3>

<ul>
	<li><strong>Time Complexity:</strong> <code>O(n * log(sum))</code></li>
	<li><strong>Space Complexity:</strong> <code>O(1)</code></li>
</ul>
