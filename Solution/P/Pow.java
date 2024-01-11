package Solution.P;

public class Pow {
}

class Solution50BinaryExponentiation {
    public double myPow(double x, int n) {
        double result = 1;
        long times = Math.abs((long)n);
        double base = x;
        while(times != 0){
            if((times & 1) == 1) result *= base;
            base *= base;
            times >>= 1;
        }
        return n < 0 ? (1 / result) : result;
    }
}
