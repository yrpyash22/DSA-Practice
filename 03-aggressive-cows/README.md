<h2>Aggressive Cows</h2><h3>Medium</h3><hr>

<p>You are given an array <code>stalls</code> representing the positions of <code>n</code> stalls and an integer <code>k</code> representing the number of cows.</p>

<p>You have to place <code>k</code> cows in the stalls such that the minimum distance between any two cows is as large as possible.</p>

<p>The cows must be placed in different stalls.</p>

<p>Return the largest possible minimum distance between any two cows.</p>

<p>&nbsp;</p>

<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> stalls = [1,2,4,8,9], k = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> One optimal way is to place the cows at positions:

1, 4, 8

The distances between consecutive cows are:
4 - 1 = 3
8 - 4 = 4

The minimum distance is 3, which is the largest possible minimum distance.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> stalls = [10,1,2,7,5], k = 3
<strong>Output:</strong> 4
<strong>Explanation:</strong> After sorting the stalls:

[1,2,5,7,10]

One optimal way is to place the cows at positions:

1, 5, 10

The distances are:
5 - 1 = 4
10 - 5 = 5

The minimum distance is 4.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> stalls = [1,2,3,4,5], k = 2
<strong>Output:</strong> 4
<strong>Explanation:</strong> Place the two cows at positions 1 and 5.

The distance between them is:
5 - 1 = 4

Therefore, the largest possible minimum distance is 4.
</pre>

<p>&nbsp;</p>

<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= stalls.length &lt;= 10<sup>5</sup></li>
	<li><code>2 &lt;= k &lt;= stalls.length</code></li>
	<li><code>0 &lt;= stalls[i] &lt;= 10<sup>9</sup></code></li>
	<li>All stall positions are distinct.</li>
</ul>

<p>&nbsp;</p>

<h3>Approach</h3>

<p>We can solve this problem using <strong>Binary Search on Answer</strong>.</p>

<p>First, sort the stall positions.</p>

<p>The minimum possible distance is <code>1</code> and the maximum possible distance is:</p>

<pre>
stalls[n - 1] - stalls[0]
</pre>

<p>For every <code>mid</code>, we check whether it is possible to place all <code>k</code> cows such that the distance between every two consecutive cows is at least <code>mid</code>.</p>

<p>If it is possible, we try to find a larger minimum distance.</p>

<p>If it is not possible, we try a smaller distance.</p>

<h3>Java Solution</h3>

<pre>
import java.util.*;

class Solution {

    public int aggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls);

        int start = 1;
        int end = stalls[stalls.length - 1] - stalls[0];

        int answer = 0;

        while (start &lt;= end) {

            int mid = start + (end - start) / 2;

            if (canPlace(stalls, k, mid)) {

                // mid distance is possible
                answer = mid;

                // Try for a larger distance
                start = mid + 1;

            } else {

                // mid distance is not possible
                end = mid - 1;
            }
        }

        return answer;
    }

    public boolean canPlace(int[] stalls, int k, int distance) {

        int cows = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i &lt; stalls.length; i++) {

            if (stalls[i] - lastPosition &gt;= distance) {

                cows++;
                lastPosition = stalls[i];
            }

            if (cows &gt;= k) {
                return true;
            }
        }

        return false;
    }
}
</pre>

<h3>Dry Run</h3>

<pre>
stalls = [1,2,4,8,9]
k = 3

After sorting:

[1,2,4,8,9]

start = 1
end = 9 - 1 = 8

mid = 4
</pre>

<pre>
Check whether 3 cows can be placed
with minimum distance 4.

First cow -> 1

2 - 1 = 1  &lt; 4
4 - 1 = 3  &lt; 4
8 - 1 = 7  &gt;= 4

Second cow -> 8

9 - 8 = 1  &lt; 4

Only 2 cows can be placed.

Therefore, distance 4 is not possible.

end = 3
</pre>

<pre>
mid = 2

First cow -> 1
Second cow -> 4
Third cow -> 8

Distances:

4 - 1 = 3
8 - 4 = 4

3 cows can be placed.

Therefore, distance 2 is possible.

answer = 2
start = 3
</pre>

<pre>
mid = 3

First cow -> 1
Second cow -> 4
Third cow -> 8

Distances:

4 - 1 = 3
8 - 4 = 4

3 cows can be placed.

Therefore, distance 3 is possible.

answer = 3
start = 4
</pre>

<p>Now <code>start &gt; end</code>, so the binary search ends.</p>

<pre>
Answer = 3
</pre>

<h3>Complexity</h3>

<ul>
	<li><strong>Time Complexity:</strong> <code>O(n log n + n log(maxDistance))</code></li>
	<li><strong>Space Complexity:</strong> <code>O(1)</code> (excluding the sorting implementation stack)</li>
</ul>

