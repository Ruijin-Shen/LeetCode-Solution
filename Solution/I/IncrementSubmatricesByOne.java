package Solution.I;

public class IncrementSubmatricesByOne {
}

class Solution2536 {
    private int[][] diff;

    public int[][] rangeAddQueries(int n, int[][] queries) {
        diff = new int[n + 2][n + 2];

        for(int[] query : queries){
            int x1 = query[0] + 1, y1 = query[1] + 1, x2 = query[2] + 1, y2 = query[3] + 1;
            diff[x1][y1] += 1;
            diff[x2 + 1][y1] -= 1;
            diff[x1][y2 + 1] -=1;
            diff[x2 + 1][y2 + 1] += 1;
        }

        int[][] result = new int[n][n];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                result[i - 1][j - 1] = diff[i][j] = diff[i][j] + diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j -1];
            }
        }

        return result;
    }
}