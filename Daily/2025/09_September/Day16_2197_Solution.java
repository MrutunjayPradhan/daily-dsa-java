import java.util.*;
public class Day16_2197_Solution {

    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> result = new LinkedList<>();
        
        for (int currentNumber : nums) {
            result.add(currentNumber);
            
            // Keep merging while we have at least 2 elements and they're non-coprime
            while (result.size() >= 2) {
                int lastNumber = result.pollLast();
                int secondLastNumber = result.pollLast();
                
                int gcdValue = gcd(lastNumber, secondLastNumber);
                
                if (gcdValue == 1) {
                    // Numbers are coprime, put them back
                    result.add(secondLastNumber);
                    result.add(lastNumber);
                    break;
                } else {
                    // Replace non-coprime numbers with their LCM
                    long lcmValue = (long) secondLastNumber * lastNumber / gcdValue;
                    result.add((int) lcmValue);
                }
            }
        }
        
        return result;
    }
    
    // Helper method to calculate Greatest Common Divisor using Euclidean algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
