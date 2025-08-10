import java.util.Arrays;
public class Day10_869_Solution {

    public boolean reorderedPowerOf2(int n) {
        int[] digitCount = countDigits(n);
        for (int i = 0; i < 31; i++) {
            int power = 1 << i;
            int[] powerDigitCount = countDigits(power);
            if (Arrays.equals(digitCount, powerDigitCount)) {
                return true;
            }
        }
        return false;
    }

    private int[] countDigits(int num) {
        int[] count = new int[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        return count;
    }
}
