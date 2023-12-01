package Solution.F;

public class FindChampionI {
}

class Solution2923 {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        for(int j = 0; j < n; j++){
            boolean flag = true;
            for(int i = 0; i < n; i++){
                if(grid[i][j] == 1){
                    flag = false;
                    break;
                }
            }
            if(flag) return j;
        }
        return -1;
    }
}