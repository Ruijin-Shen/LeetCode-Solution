package Solution.M;

public class MaximumValueAtAGivenIndexInABoundedArray {
}

class Solution1802 {
    public int maxValue(int n, int index, int maxSum) {
        if(n % 2 == 1 && index > n / 2 ) index -= 2 * (index - n / 2);
        if(n % 2 == 0 && index > (n / 2 - 1)) index -= 2 * (index - (n / 2 - 1)) - 1;

        // 求最大
        long high = sumOfArithmeticSequence(1, 1, n - index)
                + sumOfArithmeticSequence(n - 1 - index, -1, index);
        if(maxSum >= high) return (int)(n - index + (maxSum - high) / n);

        long low = sumOfArithmeticSequence(1, 1, index + 1)
                + sumOfArithmeticSequence(1, 1, index) + n - 2 * index - 1;

        int gap = n - 2 * index - 1;
        int result = index + 1;
        long residual = maxSum - low;
        if(maxSum >= low){
            while(residual >= n - gap){
                if(residual < n){
                    result += 1;
                    residual -= n - gap;
                    gap --;
                }else{
                    int delta = (int)(residual / n);
                    result += delta;
                    residual = residual % n;
                    residual += sumOfArithmeticSequence(gap, -1, delta);
                    gap -= delta;
                }
            }
            return result;
        }else{
            int effective = 2 * index - 1;
            residual = low - maxSum;
            result -= solve(residual, effective);
            return result;
        }
    }

    public static long sumOfArithmeticSequence(long a0, long d, long n){
        return a0 * n + d * n * (n - 1) / 2;
    }

    public static int solve(long target, long a0){
        return (int)Math.ceil((a0 + 1 - Math.sqrt((a0+1)*(a0+1) - 4 * target))/2);
    }
}


class Solution1802BinarySearch {
    public int maxValue(int n, int index, int maxSum) {
        // Binary Search
        int low = 1, high = maxSum + 1, mid = 0;
        while(high - low > 1){
            mid = low + ((high - low) >> 1);
            if(valid(n, index, mid, maxSum)){
                low = mid;
            }else{
                high = mid;
            }
        }
        return low;
    }

    private static boolean valid(int n, int index, int trial, int maxSum){
        long count = 0;
        // left (including)
        if(index + 1 <= trial){
            count += sumOfArithmeticSequence(trial, -1, index + 1);
        }else{
            count += sumOfArithmeticSequence(trial, -1, trial);
            count += index + 1 - trial;
        }
        // right (including)
        if(n - index <= trial){
            count += sumOfArithmeticSequence(trial, -1, n - index);
        }else{
            count += sumOfArithmeticSequence(trial, -1, trial);
            count += n - index - trial;
        }
        count -= trial;
        return count <= maxSum;
    }

    private static long sumOfArithmeticSequence(long a0, long d, long n){
        return a0 * n + d * n * (n - 1) / 2;
    }
}