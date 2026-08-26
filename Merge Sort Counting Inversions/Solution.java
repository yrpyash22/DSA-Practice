import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countInversions' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long countInversions(List<Integer> arr) {

        return mergeSort(arr, 0, arr.size() - 1);
    }

    static long mergeSort(List<Integer> arr, int left, int right) {

        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        long count = 0;

        count += mergeSort(arr, left, mid);
        count += mergeSort(arr, mid + 1, right);

        count += merge(arr, left, mid, right);

        return count;
    }

    static long merge(List<Integer> arr, int left, int mid, int right) {

        List<Integer> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;

        long count = 0;

        while (i <= mid && j <= right) {

            if (arr.get(i) <= arr.get(j)) {

                temp.add(arr.get(i));
                i++;

            } else {

                temp.add(arr.get(j));
                j++;

                count += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp.add(arr.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(arr.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            arr.set(left + k, temp.get(k));
        }

        return count;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
            new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
            );

        int t = Integer.parseInt(
            bufferedReader.readLine().trim()
        );

        IntStream.range(0, t).forEach(tItr -> {

            try {

                int n = Integer.parseInt(
                    bufferedReader.readLine().trim()
                );

                List<Integer> arr =
                    Stream.of(
                        bufferedReader
                            .readLine()
                            .replaceAll("\\s+$", "")
                            .split(" ")
                    )
                    .map(Integer::parseInt)
                    .collect(toList());

                long result = Result.countInversions(arr);

                bufferedWriter.write(
                    String.valueOf(result)
                );

                bufferedWriter.newLine();

            } catch (IOException ex) {

                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}