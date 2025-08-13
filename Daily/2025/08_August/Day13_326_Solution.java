public class Day13_326_Solution {

    public boolean isPowerOfThree(int n) {
        // 3^19 = 1162261467 is the largest power of 3 in 32-bit signed integer range
        return n > 0 && 1162261467 % n == 0;
    }
}
