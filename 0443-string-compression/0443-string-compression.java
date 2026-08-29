class Solution {
    public int compress(char[] chars) {
        
        int index = 0;

        for(int i = 0; i<chars.length; i++)
        {
            int count = 1;
            // Same char count
            while(i< chars.length -1 && chars[i] == chars[i+1])
            {
                count++;
                i++;
            }

            // Character store karo
            chars[index] = chars[i];
            index++;

            // Agar count > 1 hai
            if(count > 1)
            {
                String countString = String.valueOf(count);
                for (int j = 0; j < countString.length(); j++) 
                {
                    chars[index] = countString.charAt(j);
                    index++;
                }
            }
        }
        return index;
    }
}