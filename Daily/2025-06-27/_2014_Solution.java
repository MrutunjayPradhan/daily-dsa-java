import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class _2014_Solution {
    /**
     * Finds the longest subsequence of 's' that can be repeated at least 'k' times.
     * 
     * @param s The input string
     * @param k The minimum required repetitions
     * @return The longest valid subsequence (lexicographically largest if ties)
     */
    public String longestSubsequenceRepeatedK(String s, int k) {
        // Step 1: Preprocess character frequencies
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        // Step 2: Collect candidate characters (those appearing at least k times)
        List<Character> candidates = new ArrayList<>();
        for (int i = 25; i >= 0; i--) {
            if (freq[i] >= k) {
                candidates.add((char) ('a' + i));
            }
        }
        
        // Step 3: BFS to find the longest valid subsequence
        String result = "";
        Queue<String> queue = new LinkedList<>();
        queue.offer("");  // Start with empty string
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            
            // Try to extend with each candidate character
            for (char ch : candidates) {
                String next = current + ch;
                
                // Early pruning: skip if can't possibly beat current best
                if (next.length() + s.length() / k < result.length()) {
                    continue;
                }
                
                if (isValidSubsequence(s, next, k)) {
                    if (next.length() > result.length() || 
                        (next.length() == result.length() && next.compareTo(result) > 0)) {
                        result = next;
                    }
                    queue.offer(next);
                }
            }
        }
        
        return result;
    }
    
    /**
     * Checks if a subsequence can be found in 's' at least 'k' times.
     * Optimized with early termination.
     */
    private boolean isValidSubsequence(String s, String sub, int k) {
        int repetitions = 0;
        int subIndex = 0;
        int subLength = sub.length();
        
        for (char ch : s.toCharArray()) {
            if (ch == sub.charAt(subIndex)) {
                subIndex++;
                if (subIndex == subLength) {
                    repetitions++;
                    subIndex = 0;
                    if (repetitions == k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}