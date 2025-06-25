/**
 * Problem: 2200. Find All K-Distant Indices in an Array
 * Link: https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/
 *
 * Date: 24/06/2025
 * Language: Java
 * Level: Easy
 *
 * Approach:
 * - Iterate through each index `i` in the array.
 * - For every index, check if the `key` appears within the window `[i - k, i + k]`.
 * - If yes, add `i` to the result.
 * - Use a `lastAdded` tracker to avoid duplicate indices being added to the result list.
 *
 * Time Complexity: O(n * 2k) in the worst case (brute-force check around every index)
 * Space Complexity: O(n) for storing results
 */

import java.util.ArrayList;
import java.util.List;

public class _2200_FindKDistantIndices {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int lastAdded = -1; // To avoid duplicate additions

        for (int i = 0; i < n; i++) {
            // Scan the window [i - k, i + k] centered around index i
            for (int j = Math.max(0, i - k); j <= Math.min(n - 1, i + k); j++) {
                if (nums[j] == key) {
                    if (i > lastAdded) {
                        result.add(i);
                        lastAdded = i;
                    }
                    break; // No need to continue for current i
                }
            }
        }

        return result;
    }
}
