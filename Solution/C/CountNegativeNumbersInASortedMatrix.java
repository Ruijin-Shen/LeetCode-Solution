package Solution.C;

public class CountNegativeNumbersInASortedMatrix {
}

class Solution1351_BruteForce {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] < 0) count++;
            }
        }

        return count;
    }
}


class Solution1351_ReverseTraversal {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        int pos = n - 1;
        for(int[] ints : grid){
            int i;
            for(i = pos; i >= 0; i--){
                if(ints[i] >= 0){
                    if(i + 1 < n){
                        pos = i + 1;
                        count += n - pos;
                    }
                    break;
                }
            }
            if(i == -1){
                count += n;
                pos = -1;
            }
        }
        return count;
    }

}