package Solution.C;

public class CountTheNumberOfHousesAtACertainDistanceII {
}

class Solution3017 {
    private long[] result;

    public long[] countOfPairs(long n, long x, long y) {
        if(x > y){
            long temp = x;
            x = y; y = temp;
        }
        x--; y--;
        result = new long[(int)n];

        long mid = x + y >> 1;
        simple(x);
        circle(y - x + 1);
        connect(x, mid - x + 1, 0);
        connect(x, y - mid, 1);
        simple(n - y - 1);
        connect(x , n - y - 1, x < y ? 2 : 1);
        connect(mid - x, n - y - 1, 1);
        connect(y - mid + 1, n - y - 1, 0);

        for(int i = 0; i < n - 1; i++){
            result[i] = result[i + 1];
        }
        result[(int)n - 1] = 0;
        return result;
    }

    private void simple(long size){
        for(long i = 1; i < size; i++){
            result[(int)i] += 2 * (size - i);
        }
    }

    private void circle(long size){
        if(size == 0) return;
        for(long i = 1; i <= size / 2; i++){
            result[(int)i] += 2 * size;
        }
        if(isEven(size)) result[(int) size / 2] -= size;
    }

    private void connect(long a, long b, long gap){
        if(a <= 0 || b <= 0) return;
        long size = a + b;
        for(long i = 1; i < size; i++){
            result[(int)(i + gap)] += 2 * (size - i);
        }
        for(long i = 1; i < a; i++){
            result[(int)(i + gap)] -= 2 * (a - i);
        }
        for(long i = 1; i < b; i++){
            result[(int)(i + gap)] -= 2 * (b - i);
        }
    }

    private boolean isEven(long x){
        return x % 2 == 0;
    }
}