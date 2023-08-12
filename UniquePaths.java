public class UniquePaths {
}

class Solution62 {
    public int uniquePaths(int m, int n) {
        int[] count = new int[n];
        count[0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                count[j] += j - 1 >= 0 ? count[j - 1] : 0;
            }
        }
        return count[n - 1];
    }
}