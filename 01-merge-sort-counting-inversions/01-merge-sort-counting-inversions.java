class Solution {

    public static long countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static long mergeSort(int[] arr, int start, int end) {

        if (start >= end) {
            return 0;
        }

        int mid = start + (end - start) / 2;

        long count = 0;

        count += mergeSort(arr, start, mid);
        count += mergeSort(arr, mid + 1, end);
        count += merge(arr, start, mid, end);

        return count;
    }

    public static long merge(int[] arr, int start, int mid, int end) {

        int[] temp = new int[end - start + 1];

        int i = start;
        int j = mid + 1;
        int k = 0;

        long count = 0;

        while (i <= mid && j <= end) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } 
            else {
                temp[k++] = arr[j++];

                count += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[start + x] = temp[x];
        }

        return count;
    }
}
