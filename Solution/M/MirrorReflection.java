package Solution.M;

public class MirrorReflection {
}

class Solution858 {
    public int mirrorReflection(int p, int q) {
        int lcm = LCM(p, q);

        if(lcm / p % 2 == 0) return 0;
        return lcm / q % 2 == 0 ? 2 : 1;
    }

    private static int GCD(int a, int b){
        if(b == 0) return a;
        return GCD(b, a % b);
    }

    private static int LCM(int a, int b){
        return a * b / GCD(a, b);
    }
}