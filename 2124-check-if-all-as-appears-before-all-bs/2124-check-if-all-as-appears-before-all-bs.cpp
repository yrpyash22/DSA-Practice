class Solution {
public:
    bool checkString(string s) {
        
        int n = s.length();

        bool foundb = false;

        for(int i=0; i<n; i++)
        {
            if(s[i] == 'b')
            {
                foundb = true;
            }
            
            if(s[i] == 'a' && foundb)
            {
                return false;
            }
        }

        return true;
    }
};