import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLucky(int[] arr) {
        // Step 1: Count frequencies using HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Find the maximum lucky number
        int maxLucky = -1;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                maxLucky = Math.max(maxLucky, entry.getKey());
            }
        }
        
        return maxLucky;
    }
}