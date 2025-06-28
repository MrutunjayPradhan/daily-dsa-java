import java.util.Arrays;

class _2099_Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Edge case: if k equals array length, return the entire array
        if (k == nums.length) {
            return nums.clone();
        }

        // Create a copy of the array to sort
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        
        // Find the threshold value (smallest value in top k elements)
        int threshold = sorted[nums.length - k];
        
        // Count how many times the threshold value appears in top k
        int thresholdCount = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            if (sorted[i] == threshold) {
                thresholdCount++;
            }
        }

        // Prepare result array
        int[] result = new int[k];
        int index = 0;
        
        // Iterate through original array to maintain order
        for (int num : nums) {
            if (index == k) break;
            
            if (num > threshold) {
                result[index++] = num;
            } 
            else if (num == threshold && thresholdCount > 0) {
                result[index++] = num;
                thresholdCount--;
            }
        }

        return result;
    }
}