/**
 * Problem: 2081. Sum of k-Mirror Numbers
 * Link: https://leetcode.com/problems/sum-of-k-mirror-numbers/
 *
 * A k-mirror number is a number that is:
 * 1. Palindromic in base-10
 * 2. Palindromic in base-k
 *
 * This program finds the sum of the first `n` such k-mirror numbers.
 *
 * Approach:
 * - Generate palindromes in base-10 by reflecting half-numbers (both odd and even length).
 * - For each palindrome, check if it's also a palindrome in base-k.
 * - Continue until we find n such numbers and return their sum.
 *
 * Time Complexity: Approx. O(n * log(m)), where m is the generated palindrome
 * Space Complexity: O(1) auxiliary, O(d) for base-k digit storage
 */

public class _2081_Sum_of_k_Mirror_Numbers {

    // Array to store digits of a number in base-k
    private int[] digit = new int[100];

    /**
     * Finds the sum of the first `n` k-mirror numbers.
     *
     * @param k Base in which the number should also be a palindrome
     * @param n Count of k-mirror numbers to find
     * @return Sum of the first `n` k-mirror numbers
     */
    public long kMirror(int k, int n) {
        int left = 1, count = 0;
        long ans = 0;

        // Generate palindromes in increasing order
        while (count < n) {
            int right = left * 10;

            // op = 0: odd-length palindromes, op = 1: even-length palindromes
            for (int op = 0; op < 2; ++op) {
                for (int i = left; i < right && count < n; ++i) {
                    long combined = i;
                    int x = (op == 0) ? i / 10 : i;

                    // Create palindrome by mirroring the first half
                    while (x > 0) {
                        combined = combined * 10 + (x % 10);
                        x /= 10;
                    }

                    // Check if it's also a palindrome in base-k
                    if (isPalindrome(combined, k)) {
                        ++count;
                        ans += combined;
                    }
                }
            }

            // Move to the next digit range
            left = right;
        }

        return ans;
    }

    /**
     * Checks if a number is a palindrome in base-k.
     *
     * @param x Number to check
     * @param k Base to convert the number into
     * @return True if x is a palindrome in base-k
     */
    private boolean isPalindrome(long x, int k) {
        int length = -1;

        // Convert x to base-k and store digits
        while (x > 0) {
            digit[++length] = (int) (x % k);
            x /= k;
        }

        // Check if the base-k representation is a palindrome
        for (int i = 0, j = length; i < j; ++i, --j) {
            if (digit[i] != digit[j]) {
                return false;
            }
        }

        return true;
    }
}
