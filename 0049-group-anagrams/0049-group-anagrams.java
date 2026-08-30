class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {


        //input = ["eat","tea","tan","ate","nat","bat"]
        
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs)
        {
            char chars[] = str.toCharArray();       // eat→['e','a','t'], tea, tan

            Arrays.sort(chars);                      // (a,e,t), (a,e,t), (a,n,t)

            String key = new String(chars);         // [aet], [aet], [ant]

            if(!map.containsKey(key))       // (F), (T)!, (F)
            {
                map.put(key, new ArrayList<>());      // {aet, []}, {ant, []}
            }
            map.get(key).add(str);          // {aet,[eat]}, {aet,[eat, tea]}, {ant, [tan]}, .. ..
        }
        return new ArrayList<>(map.values());       // [["bat"],["nat","tan"],["ate","eat","tea"]]
    }
}