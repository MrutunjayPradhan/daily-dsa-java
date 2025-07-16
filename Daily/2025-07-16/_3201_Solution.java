public class _3201_Solution {
    public int maximumLength(int[] nums) {
        // int n = nums.length;
        // int evenCount = 0;
        // int oddCount = 0;
        
        // for (int num : nums) {
        //     if (num % 2 == 0) {
        //         evenCount++;
        //     } else {
        //         oddCount++;
        //     }
        // }
        
        // // Case 1: All elements same parity
        // int sameParity = Math.max(evenCount, oddCount);
        
        // // Case 2: Alternating parity
        // int maxAlternating = 0;
        
        // // Start with even
        // int currentParity = 0; // 0 for even, 1 for odd
        // int count = 0;
        // for (int num : nums) {
        //     if (num % 2 == currentParity) {
        //         count++;
        //         currentParity ^= 1; // toggle parity
        //     }
        // }
        // maxAlternating = count;
        
        // // Start with odd
        // currentParity = 1;
        // count = 0;
        // for (int num : nums) {
        //     if (num % 2 == currentParity) {
        //         count++;
        //         currentParity ^= 1;
        //     }
        // }
        // maxAlternating = Math.max(maxAlternating, count);
        
        // return Math.max(sameParity, maxAlternating);
        /*
         * int evenCount = 0, oddCount = 0;
        for (int num : nums) {
            if (num % 2 == 0) evenCount++;
            else oddCount++;
        }
        
        // Case 1: All same parity
        int sameParity = Math.max(evenCount, oddCount);
        
        // Case 2: Alternating parity
        int maxAlternating = Math.max(
            getAlternatingLength(nums, 0), // Start with even
            getAlternatingLength(nums, 1)  // Start with odd
        );
        
        return Math.max(sameParity, maxAlternating);
    }
    
    private int getAlternatingLength(int[] nums, int startParity) {
        int count = 0;
        int expectedParity = startParity;
        for (int num : nums) {
            if (num % 2 == expectedParity) {
                count++;
                expectedParity ^= 1; // Toggle parity
            }
        }
        return count;
         */

         int[] count = new int[2]; // count[0] = even, count[1] = odd
        int[] end = new int[2];   // end[0] = longest ending with even, similarly for odd

        for (int num : nums) {
            int parity = num % 2;
            count[parity]++;
            end[parity] = end[1 - parity] + 1; // Extend the opposite parity's subsequence
        }

        return Math.max(
            Math.max(count[0], count[1]), // All same parity
            Math.max(end[0], end[1])      // Best alternating
        );
    }
}