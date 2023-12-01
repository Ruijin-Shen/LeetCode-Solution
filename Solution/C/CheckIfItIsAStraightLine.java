package Solution.C;

public class CheckIfItIsAStraightLine {
}

class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];

        boolean flag = true;
        for(int i = 0; i < n - 1; i++){
            int[] cd1 = coordinates[i];
            int[] cd2 = coordinates[i + 1];
            if((cd2[0] - cd1[0]) * dy != (cd2[1] - cd1[1]) * dx) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static int GCD(int a, int b){
        if(b == 0) return a;
        return GCD(b, a % b);
    }
}