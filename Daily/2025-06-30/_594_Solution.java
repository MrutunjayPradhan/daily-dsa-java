import java.util.HashMap;
import java.util.Map;

public class _594_Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxLen = 0;
        
        // Count the frequency of each number
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // Check for each number if num+1 exists
        for (int num : freq.keySet()) {
            if (freq.containsKey(num + 1)) {
                maxLen = Math.max(maxLen, freq.get(num) + freq.get(num + 1));
            }
        }
        
        return maxLen;
    }
}
    
