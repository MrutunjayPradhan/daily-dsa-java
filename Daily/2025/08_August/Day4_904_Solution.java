import java.util.HashMap;

public class Day4_904_Solution {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }
        
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            
            while (map.size() > 2) {
                int count = map.get(fruits[left]);
                if (count == 1) {
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], count - 1);
                }
                left++;
            }
            
            max = Math.max(max, right - left + 1);
        }
        
        return max;
    }
}
