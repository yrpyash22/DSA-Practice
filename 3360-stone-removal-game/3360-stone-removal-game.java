class Solution {
    public boolean canAliceWin(int n) {

        // Input: n = 12

        int stone = n;     // 12
        int remove = 10;
        boolean alice = true;

        while(stone >= remove)  // (12>10), (2>=10)!
        {
            stone = stone - remove;   // [12-10]2
            remove--;   // 9

            alice = !alice; // F
        }

        return !alice;  // T
    }
}