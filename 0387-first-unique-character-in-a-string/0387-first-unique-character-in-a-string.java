class Solution {
    public int firstUniqChar(String s) {
        
        int freq[] = new int[26];

        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i<s.length(); i++)
        {
            char ch = s.charAt(i);

            freq[ch - 'a']++;
            q.add(ch);
        }

        int index = 0;

        while(!q.isEmpty())
        {
            char ch = q.remove();

            if(freq[ch - 'a'] == 1)
            {
                return index;
            }
            index++;
        }
        return -1;
    }
}