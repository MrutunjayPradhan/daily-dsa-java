import java.util.Arrays;

public class Day8_2300_Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
          Arrays.sort(potions); // Sort potions
        int[] result = new int[spells.length];
        int m = potions.length;

        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            long minPotion = (success + spell - 1) / spell; // Ceiling of success / spell

            // Use binary search to find the first valid potion
            int left = 0, right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (potions[mid] >= minPotion) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = m - left; // Remaining potions are valid
        }
        return result;
    }

}
