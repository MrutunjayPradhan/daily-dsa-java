/**
 * LeetCode Problem 2138 - Divide a String Into Groups of Size k
 * Difficulty: Easy
 * 
 * Problem Link:
 * https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/
 * 
 * Approach:
 * - Traverse the input string in steps of k characters.
 * - For the last group (if its length is less than k), pad it with the given `fill` character.
 * - Store each group in a list and convert it to a string array at the end.
 * 
 * Time Complexity: O(n), where n is the length of the string.
 * Space Complexity: O(n) for storing the resulting groups.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {

    public String[] divideString(String s, int k, char fill) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        int curr = 0;

        // Split string into groups of size k
        while (curr < n) {
            int end = Math.min(curr + k, n);
            res.add(s.substring(curr, end));
            curr += k;
        }

        // Fill the last group if needed
        String last = res.get(res.size() - 1);
        if (last.length() < k) {
            last += String.valueOf(fill).repeat(k - last.length());
            res.set(res.size() - 1, last);
        }

        return res.toArray(new String[0]);
    }
}
