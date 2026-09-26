class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        
        HashMap<String, String> map = new HashMap<>();

        for(List<String> pair: knowledge)
        {
            // here put all key-value in map
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder res = new StringBuilder();

        int i =0;
        while(i<s.length())
        {
            // Normal character
            if(s.charAt(i) != '(')
            {
                res.append(s.charAt(i));
                i++;
            }
            // Bracket pair
            else{
                int j = i+1;
                while(s.charAt(j) != ')')
                {
                    j++;
                }

                // Extract key
                String key = s.substring(i + 1, j);

                // Check HashMap
                if(map.containsKey(key))
                {
                    res.append(map.get(key));
                }
                else {
                    res.append("?");
                }

                // Move after ')'
                i = j + 1;
            }
        }
        return res.toString();
    }
}