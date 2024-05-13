package Solution.T;

import java.util.*;

public class TheKthFactorOfN {
}

class Solution1492 {
    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        int count = factors.size() * 2 - (factors.getLast() * factors.getLast() == n ? 1 : 0);
        if (k > count) return -1;
        if (k > factors.size()) {
            k = count - k;
            return n / factors.get(k);
        } else {
            return factors.get(k - 1);
        }
    }
}