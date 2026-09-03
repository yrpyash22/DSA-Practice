import java.util.*;

class Solution {

    public int aggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls);

        int start = 1;
        int end = stalls[stalls.length - 1] - stalls[0];

        int answer = 0;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (canPlace(stalls, k, mid)) {

                // mid distance possible hai
                answer = mid;

                // aur bada distance try karo
                start = mid + 1;

            } else {

                // mid distance possible nahi hai
                end = mid - 1;
            }
        }

        return answer;
    }

    public boolean canPlace(int[] stalls, int k, int distance) {

        int cows = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - lastPosition >= distance) {

                cows++;
                lastPosition = stalls[i];
            }

            if (cows >= k) {
                return true;
            }
        }

        return false;
    }
}
