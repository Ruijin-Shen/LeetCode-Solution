public class ReverseInteger {
}

class Solution7 {
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
