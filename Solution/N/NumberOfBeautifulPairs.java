package Solution.N;

public class NumberOfBeautifulPairs {
}

class Solution2748 {
    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(gcd(findFirst(nums[i]), findLast(nums[j])) == 1) count += 1;
            }
        }
        return count;
    }

    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    private static int findFirst(int a){
        int mask = 10000;
        while(mask != 0){
            if(a / mask != 0) return a / mask;
            mask /= 10;
        }
        return 0;
    }

    private static int findLast(int a){
        return a % 10;
    }
}
