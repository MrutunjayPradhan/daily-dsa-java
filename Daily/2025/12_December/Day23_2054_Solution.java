import java.util.Arrays;

public class Day23_2054_Solution {
    public int maxTwoEvents(int[][] events) {
        // Step 1: Sort events by their end times
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        int n = events.length;
        int[] maxValue = new int[n]; // Maximum value for events up to index i
        maxValue[0] = events[0][2]; // Initialize with the value of the first event
        int maxSum = maxValue[0];   // Track the maximum sum

        // Step 2: Iterate through events to calculate maximum values
        for (int i = 1; i < n; i++) {
            // Update maxValue[i] for the current event
            maxValue[i] = Math.max(maxValue[i - 1], events[i][2]);

            // Find the last non-overlapping event
            int prevIndex = binarySearch(events, i);
            if (prevIndex != -1) {
                // Combine current event with the best value of the non-overlapping event
                maxSum = Math.max(maxSum, events[i][2] + maxValue[prevIndex]);
            } else {
                // If no non-overlapping event exists, consider only the current event
                maxSum = Math.max(maxSum, events[i][2]);
            }
        }

        return maxSum;
    }

    // Binary search to find the last non-overlapping event
    private int binarySearch(int[][] events, int currentIndex) {
        int low = 0, high = currentIndex - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (events[mid][1] < events[currentIndex][0]) {
                if (mid + 1 < events.length && events[mid + 1][1] < events[currentIndex][0]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
