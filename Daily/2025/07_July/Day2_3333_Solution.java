import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2_3333_Solution {
    private static final int MOD = 1_000_000_007;

    public int possibleStringCount(String word, int k) {
        int n = word.length();
        List<Integer> runs = new ArrayList<>();
        int currentRun = 1;
        
        // Calculate run lengths
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i-1)) {
                currentRun++;
            } else {
                runs.add(currentRun);
                currentRun = 1;
            }
        }
        runs.add(currentRun);

        // Calculate initial product
        long total = 1;
        for (int run : runs) {
            total = (total * run) % MOD;
        }

        // If all runs are already within limit, return total
        if (runs.size() >= k) {
            return (int) total;
        }

        // DP arrays
        int[] dp = new int[k];
        int[] prefix = new int[k];
        dp[0] = 1;
        Arrays.fill(prefix, 1);

        for (int run : runs) {
            int[] newDp = new int[k];
            for (int j = 1; j < k; j++) {
                newDp[j] = prefix[j-1];
                if (j - run - 1 >= 0) {
                    newDp[j] = (newDp[j] - prefix[j - run - 1] + MOD) % MOD;
                }
            }
            
            // Update prefix sums
            int[] newPrefix = new int[k];
            newPrefix[0] = newDp[0];
            for (int j = 1; j < k; j++) {
                newPrefix[j] = (newPrefix[j-1] + newDp[j]) % MOD;
            }
            
            dp = newDp;
            prefix = newPrefix;
        }

        return (int) ((total - prefix[k-1] + MOD) % MOD);
    }
}

// public class Day2_3333_Solution {
//     public static void main(String[] args){

//         Solution solution = new Solution();
//         String word = "aabbccdd";
//         int k =7;
//         int result =solution.possibleStringCount(word,k);
//         System.out.println(result);//5
//     }
    
// }
