class Solution {
    public String reverseWords(String s) {

        // Extra spaces remove karke words ko array mein store karo
        // extra space and space remove by trim fun and split("\\s+")
        String[] words = s.trim().split("\\s+");
        String result = "";

        // Last word se first word tak
        for(int i = words.length -1; i >= 0; i--)
        {
            result = result + words[i];

            // Space add karne ke liye word ke baad
            if(i != 0)
            {
                result = result + " ";
            }
        }
        return result;
    }
}