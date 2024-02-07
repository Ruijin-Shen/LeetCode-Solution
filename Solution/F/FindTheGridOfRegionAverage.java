package Solution.F;

public class FindTheGridOfRegionAverage {
}

class Solution3030 {

    private static final int[][] PAIR = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] resultGrid(int[][] image, int threshold) {
        int m = image.length, n = image[0].length;
        int[][][] result = new int[2][m][n];
        for(int i = 1; i < m - 1; i++){
            for(int j = 1; j < n - 1; j++){
                if(isValid(image, threshold, i, j)){
                    set(image, result, i, j);
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(result[1][i][j] == 0)  result[0][i][j] = image[i][j];
                else result[0][i][j] = result[0][i][j] / result[1][i][j];
            }
        }
        return result[0];
    }

    private boolean isValid(int[][] image, int threshold, int i, int j){
        int diff;
        for(int[] pair : PAIR){
            diff = image[i][j] - image[i + pair[0]][j + pair[1]];
            if(diff < -threshold || diff > threshold) return false;
        }

        int x = i - 1, y = j - 1;
        diff = image[x][y] - image[x + 1][y];
        if(diff < -threshold || diff > threshold) return false;
        diff = image[x][y] - image[x][y + 1];
        if(diff < -threshold || diff > threshold) return false;

        x = i - 1; y = j + 1;
        diff = image[x][y] - image[x][y - 1];
        if(diff < -threshold || diff > threshold) return false;
        diff = image[x][y] - image[x + 1][y];
        if(diff < -threshold || diff > threshold) return false;

        x = i + 1; y = j - 1;
        diff = image[x][y] - image[x - 1][y];
        if(diff < -threshold || diff > threshold) return false;
        diff = image[x][y] - image[x][y + 1];
        if(diff < -threshold || diff > threshold) return false;

        x = i + 1; y = j + 1;
        diff = image[x][y] - image[x - 1][y];
        if(diff < -threshold || diff > threshold) return false;
        diff = image[x][y] - image[x][y - 1];
        if(diff < -threshold || diff > threshold) return false;

        return true;
    }

    private void set(int[][] image, int[][][] result, int i, int j){
        int sum = 0;
        for(int m = i - 1; m <= i + 1; m++){
            for(int n = j - 1; n <= j + 1; n++){
                sum += image[m][n];
            }
        }
        int avg = sum / 9;
        for(int m = i - 1; m <= i + 1; m++){
            for(int n = j - 1; n <= j + 1; n++){
                result[0][m][n] += avg;
                result[1][m][n]++;
            }
        }
    }
}