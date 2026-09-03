package Array;

import java.util.Arrays;

public class Reverse_array {

    public static int[] reverse_array(int nums[]) {

        int first = 0;
        int last = nums.length - 1;

        while (first < last) {

            int temp = nums[last];
            nums[last] = nums[first];
            nums[first] = temp;

            first++;
            last--;
        }

        return nums;
    }

    public static void main(String[] args) {

        int nums[] = {2, 4, 6, 8, 9, 5, 4, 10, 7, 22, 41};

        System.out.println("Actual Array  : " + Arrays.toString(nums));

        reverse_array(nums);

        System.out.println("Reverse Array : " + Arrays.toString(nums));
    }
}