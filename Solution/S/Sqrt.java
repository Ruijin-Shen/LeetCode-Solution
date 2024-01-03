package Solution.S;

public class Sqrt {
}

class Solution69BinarySearch {
    public int mySqrt(int x) {
        double left = 0, right = x;
        while(right - left > 1e-6){
            double mid = (left + right) / 2;
            if(mid * mid < x) left = mid;
            else right = mid;
        }
        return (int)right;
    }
}