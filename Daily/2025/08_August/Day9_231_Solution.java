public class Day9_231_Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<1) return false ;
        return( n & (n-1))==0;
    }
}