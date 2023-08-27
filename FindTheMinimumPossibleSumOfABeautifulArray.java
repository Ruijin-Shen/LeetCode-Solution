import java.util.*;

public class FindTheMinimumPossibleSumOfABeautifulArray {
}

class Solution2834 {
    public long minimumPossibleSum(int n, int target) {
        if(n == 1) return 1;
        long sum = 0;
        HashSet<Integer> ban = new HashSet<>();
        for(int i = 1, count = 0; count < n; i++){
            if(ban.contains(i)) continue;
            if(target - i > 0) ban.add(target - i);
            sum += (long)i;
            count++;
        }
        return sum;
    }
}

class Solution2834Math {
    public long minimumPossibleSum(int n, int target) {
        if(n == 1) return 1;
        long boundary = target / 2;
        long result = 0;

        if(n <= boundary){
            return (1L + n) * n / 2;
        }else{
            result += (1L + boundary) * boundary / 2;
            result += (target + target + n - boundary - 1) * (n - boundary) / 2;
            return result;
        }
    }
}