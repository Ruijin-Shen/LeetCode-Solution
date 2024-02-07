package Solution.P;

public class PowerOfThree {
}

class Solution326 {
    public boolean isPowerOfThree(int n) {
        if(n == 1) return true;
        if(n <= 0 || n % 3 != 0) return false;
        return isPowerOfThree(n / 3);
    }
}