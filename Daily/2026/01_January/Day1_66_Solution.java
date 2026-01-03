public class Day1_66_Solution {
   
        public int[] plusOne(int[] digits) {
        int length = digits.length;
        int l = length;
        boolean n = true;
        try {

            while (n) {

                if (digits[l - 1] < 9) {
                    digits[l - 1] = digits[l - 1] + 1;
                    n = false;
                } else {
                    digits[l - 1] = 0;
                    l--;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            int[] b = new int[length + 1];
            b[0] = 1;
           
            return b;
        }
        int[] a = digits;
        return a;
    }
         

}
