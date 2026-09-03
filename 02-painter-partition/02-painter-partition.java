class Solution {

    public int painterPartition(int[] boards, int k) {

        int start = 0;
        int end = 0;

        // Find maximum board and total sum
        for (int board : boards) {
            start = Math.max(start, board);
            end += board;
        }

        int answer = end;

        while (start <= end) 
        {
            int mid = (start + end) / 2;
            if (canPaint(boards, k, mid)) {
                // mid maximum workload possible hai
                answer = mid;

                // Aur minimum try karo
                end = mid - 1;

            } else {

                // mid possible nahi hai
                start = mid + 1;
            }
        }

        return answer;
    }

    public boolean canPaint(int[] boards, int k, int maxWork) {

        int painters = 1;
        int currentWork = 0;

        for (int board : boards) {

            if (currentWork + board <= maxWork) {

                currentWork += board;

            } else {

                // New painter
                painters++;
                currentWork = board;
            }
        }

        return painters <= k;
    }
}
