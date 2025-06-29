package Arrays;


import java.util.*;

public class _56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals based on start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> results = new ArrayList<>();
        int size = 0;

        for (int[] interval : intervals) {
            if (results.isEmpty() || results.get(size - 1)[1] < interval[0]) {
                results.add(interval);
                size++;
            } else {
                results.get(size - 1)[1] = Math.max(results.get(size - 1)[1], interval[1]);
            }
        }

        return results.toArray(new int[size][]);
    }
}

