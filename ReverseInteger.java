public class ReverseInteger {
}

class Solution7MySolution {
    private static final String MAX = "2147483647";

    public int reverse(int x) {
        if(x == Integer.MIN_VALUE) return 0;

        int sig = x < 0 ? -1 : 1;
        if(sig == -1) x = -x;

        String xStr = Integer.toString(x);
        String xRev = new StringBuffer(xStr).reverse().toString();
        if(xRev.length() < MAX.length() || xRev.compareTo(MAX) <= 0){
            return sig * Integer.parseInt(xRev);
        }else{
            return 0;
        }
    }
}

class Solution7 {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}