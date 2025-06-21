/**
 * LeetCode Daily Challenge: Problem 3085 - Minimum Deletions to Make String K-Special
 * Difficulty: Medium
 * Date Solved: YYYY-MM-DD
 *
 * Problem Link:
 * https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/
 *
 * Approach:
 * - Count the frequency of each character in the string.
 * - For each possible target frequency `a`, calculate how many deletions are needed:
 *     - Delete all characters with frequency < a.
 *     - For frequencies > a + k, delete the excess (b - (a + k)).
 * - Track the minimum deletions across all possible `a` values.
 *
 * Time Complexity: O(n^2) in worst case (if all characters are unique)
 * Space Complexity: O(1) since map size is limited to 26 lowercase English letters
 */

import java.util.HashMap;
import java.util.Map;

class Solution_3085 {
    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> cnt = new HashMap<>();

        // Count frequency of each character
        for (char ch : word.toCharArray()) {
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
        }

        int res = word.length();

        // Try making every frequency as base
        for (int a : cnt.values()) {
            int deleted = 0;

            for (int b : cnt.values()) {
                if (a > b) {
                    deleted += b;
                } else if (b > a + k) {
                    deleted += b - (a + k);
                }
            }

            res = Math.min(res, deleted);
        }

        return res;
    }
}
