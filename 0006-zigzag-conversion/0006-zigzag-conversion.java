class Solution {
    public String convert(String s, int numRows) {

        // s = "PAYPALISHIRING", numRows = 3
        
        if(numRows == 1 || s.length() <= numRows)
        {
            return s;
        }

        StringBuilder rows[] = new StringBuilder[numRows];  // 3
        for(int i = 0; i< numRows; i++)   // 0, 1, 2
        {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean goDown = false;

        // Put every character in its correct row
        for(char ch : s.toCharArray())
        {
            // Put perticular char in row
            rows[currRow].append(ch);   // [0]=P, [1]=A, [2]=Y, [1]=AP, [0]=PA

            // Change the direction of row at top to down
            if(currRow == 0 || currRow == numRows - 1)      //(0==0), (1==2)!, (2==2), (1==2)! 
            {
                goDown = !goDown;
            }

            if(goDown)          // (T), (T), (F)
            {
                currRow++;      // 1, 2
            }
            else{
                currRow--;     // 1, 0
            }
        }

        // Add and combine all rows
        StringBuilder ans = new StringBuilder();

        for(StringBuilder row: rows)
        {
            ans.append(row);
        }

        return ans.toString();
    }
}
