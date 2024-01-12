package Solution.H;

import java.util.HashSet;

public class HappyNumber {
}

class Solution202 {
    public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<>();
        while(n != 1){
            if(visited.contains(n)) return false;
            visited.add(n);
            n = compute(n);
        }
        return true;
    }

    private static int compute(int n){
        int result = 0;
        while(n > 0){
            int digit = n % 10;
            result += digit * digit;
            n /= 10;
        }
        return result;
    }
}