import java.util.Set;
import java.util.HashSet;

public class Day22_1695_Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int i = 0, j = 0;
        int n = nums.length;
        int maxVal = 0;
        while (i < n) {
            int currVal = nums[i];
            if (!set.contains(currVal)) {
                set.add(currVal);
                sum += currVal;
                maxVal = Math.max(sum, maxVal);
                i++;
            } else {
                int back = nums[j];
                sum -= back;
                set.remove(back);
                j++;
            }
            // System.out.println(set);
        }
        return maxVal;
    }
}