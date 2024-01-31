package Solution.P;

public class PowerOfTwo {
}

class Solution231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n == (n & -n));
    }
}