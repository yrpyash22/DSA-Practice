class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Ex ==> strs = ["flower","flow","flight"]
        
        String prefix = strs[0];        // flower

        for(int i = 1; i<strs.length; i++)      // 1, 2
        {
            while(!strs[i].startsWith(prefix))    //(flow.[flower]), (flow.[flowe]), (flow.[flow])!   | (flight.[flow]), (flight.[flo]), (flight.[fl])!
            {
                prefix = prefix.substring(0, prefix.length() - 1);  // [flower.[0,5]=[flowe], [flowe.[0,4]=[flow]  | [flow.[0,3]=[flo], . ....

                if(prefix.length() == 0)
                {
                    return "";
                }
            }
        }
        return prefix;  // fl
    }
}