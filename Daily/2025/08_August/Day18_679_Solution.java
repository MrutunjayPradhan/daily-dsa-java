import java.util.ArrayList;
import java.util.List;
public class Day18_679_Solution {
    
    private static final double EPSILON = 1e-6;
    
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int num : cards) {
            nums.add((double) num);
        }
        return dfs(nums);
    }
    
    private boolean dfs(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24.0) < EPSILON;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) continue;
                
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        next.add(nums.get(k));
                    }
                }
                
                double a = nums.get(i), b = nums.get(j);
                
                // Try all possible operations
                for (int op = 0; op < 4; op++) {
                    // Skip commutative operations that have been tried before
                    if (op < 2 && i > j) continue;
                    
                    switch (op) {
                        case 0: next.add(a + b); break;
                        case 1: next.add(a * b); break;
                        case 2: next.add(a - b); break;
                        case 3: 
                            if (Math.abs(b) < EPSILON) continue;
                            next.add(a / b); 
                            break;
                    }
                    
                    if (dfs(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    
    }
}

