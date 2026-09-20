class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        
        int n = s.length();
        int first[] = new int[26];
        int last[] = new int[26];

        Arrays.fill(first, -1);

        // There find first and last occurance of every char
        for(int i =0; i<n; i++)
        {
            int ch = s.charAt(i) - 'a';

            if(first[ch] == -1)
            {
                first[ch] = i;
            }
            last[ch] = i;
        }

        // Store all valid intervals
        List<int[]> intervals = new ArrayList<>();

        for(int c= 0; c<26; c++)
        {
            if(first[c] == -1)
            {
                continue;
            }

            int left = first[c];
            int right = last[c];

            boolean valid = true;

            for(int i = left; i<= right; i++)
            {
                int ch = s.charAt(i) - 'a';
                
                if(first[ch] < left)
                {
                    valid = false;
                    break;
                }

                // Need to include all occurrences of this character
                right = Math.max(right, last[ch]);
            }

            if(valid)
            {
                intervals.add(new int[]{left, right});
            }
        }


        // Sort by ending position
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));
        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        for (int[] interval : intervals)
        {
            int left = interval[0];
            int right = interval[1];

            // Non-overlapping
            if (left > prevEnd) {
                ans.add(s.substring(left, right + 1));
                prevEnd = right;
            }
        }
        return ans;
    }
}