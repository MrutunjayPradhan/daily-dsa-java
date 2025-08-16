public class Day16_1323_Solution{
    public int maximum69Number(int num) {
        boolean isChanged = false;
        int newNum = 0;
        int reversed = 0;
        
        // Reverse the number first
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        
        // Process the reversed number
        while (reversed > 0) {
            int temp = reversed % 10;
            if (!isChanged && temp == 6) {
                temp = 9;
                isChanged = true;
            }
            newNum = newNum * 10 + temp;
            reversed /= 10;
        }
        
        return newNum;
    }
}