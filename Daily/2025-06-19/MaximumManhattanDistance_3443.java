// Java solution
/**
 * Problem: Maximum Manhattan Distance After K Changes
 * Link: https://leetcode.com/problems/maximum-manhattan-distance-after-k-changes/editorial/?envType=daily-question&envId=2025-06-20
 *
 * Approach:
 * This code calculates the maximum possible Manhattan distance that can be achieved by modifying
 * at most k characters in a string s consisting of directions ('N', 'S', 'E', 'W').
 *
 * Strategy:
 * - Count the number of times each direction occurs as we iterate through the string.
 * - At each step:
 *      1. Use up to k modifications to balance N↔S.
 *      2. Use remaining modifications to balance E↔W.
 * - Each N↔S or E↔W change increases the Manhattan distance by 2.
 * - Compute potential distance at each step and store the maximum.
 *
 * Time Complexity: O(n), where n is the length of the input string.
 * Space Complexity: O(1), using only constant space.
 */

 public class MaximumManhattanDistance_3443 {

    /**
     * Calculates the maximum Manhattan distance achievable by modifying at most k characters in the string.
     *
     * @param s The input string containing directions ('N', 'S', 'E', 'W')
     * @param k The maximum number of character modifications allowed
     * @return The maximum achievable Manhattan distance
     */
    public int maxDistance(String s, int k) {
        int ans = 0; // Stores the maximum distance found so far

        // Counters for each direction
        int north = 0, south = 0, east = 0, west = 0;

        // Iterate through each character in the string
        for (char it : s.toCharArray()) {
            // Update the count for the current direction
            switch (it) {
                case 'N': north++; break;
                case 'S': south++; break;
                case 'E': east++; break;
                case 'W': west++; break;
            }

            // Use modifications to balance N/S directions (up to k)
            int times1 = Math.min(Math.min(north, south), k);

            // Use remaining modifications to balance E/W directions
            int times2 = Math.min(Math.min(east, west), k - times1);

            // Calculate the current maximum distance
            ans = Math.max(
                ans,
                count(north, south, times1) + count(east, west, times2)
            );
        }

        return ans;
    }

    /**
     * Helper method to calculate the contribution to Manhattan distance from a pair of opposite directions
     * after applying modifications.
     *
     * @param drt1  Count of one direction (e.g., north or east)
     * @param drt2  Count of the opposite direction (e.g., south or west)
     * @param times Number of modifications applied to this pair
     * @return The Manhattan distance contribution
     */
    private int count(int drt1, int drt2, int times) {
        // Each modification flips a direction, increasing the difference by 2
        return Math.abs(drt1 - drt2) + times * 2;
    }
}
