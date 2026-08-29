class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // Ex ==> s1 = "ab", s2 = "eidbaooo"

        // Agar s1 ki length s2 se badi hai
        if(s1.length() > s2.length())       // (2>8)!
        {
            return false;
        }

        // 26 lowercase letters ke liye frequency count
        int count1[] = new int[26];
        int count2[] = new int[26];

        // s1 ke characters ki frequency
        for(int i =0; i<s1.length(); i++)       // 0, 1
        {
            count1[s1.charAt(i) - 'a']++;       // [a-a]{0}, [b-a]{1}  ==> {1[0], 1[1]} 
        }

        // s2 ki first window // count match karne ke liye
        for (int i = 0; i < s1.length(); i++)       // 0, 1
        {
            count2[s2.charAt(i) - 'a']++;           // [e-a]{4}, [i-a]{8}  ==> {1[4], 1[8]}
        }

        // First Window Check 
        if(matches(count1, count2))         // (ab,ei)!
        {
            return true;
        }

        // Sliding window
        for(int i = s1.length(); i< s2.length(); i++)       // 2,3,4/,5,6,7
        {
            // New character window mein add
            count2[s2.charAt(i) - 'a']++;                   // [ei → eid], [id-> idb], [db->dba]

            // Old char ko window se remove
            count2[s2.charAt(i - s1.length()) - 'a']--;     // [eid -> id], [idb->db], [dba->ba] 

            // Frequency same hai?
            if (matches(count1, count2))                    // (ab,id)!, (ab,db)!, (ba,ab)
            {
                return true;
            }
        }
        return false;
    }

    // Dono frequency arrays compare karne ke liye
    public boolean matches(int a[], int b[])
    {
        for(int i = 0; i<26; i++)
        {
            if(a[i] != b[i])
            {
                return false;
            }
        }
        return true;
    }
}