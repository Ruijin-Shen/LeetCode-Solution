package Solution.A;

public class AliceAndBobPlayingFlowerGame {
}

class Solution3021 {
    public long flowerGame(int n, int m) {
        long nOdd = (n + 1) / 2;
        long nEven = n / 2;
        long mOdd = (m + 1) / 2;
        long mEven = m / 2;

        return nOdd * mEven + nEven * mOdd;
    }
}