package Solution.P;

public class PowerOfFour {
}

class Solution342 {
    public boolean isPowerOfFour(int n) {
        // return Integer.toString(n, 4).matches("^10*$");
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }
}