package Solution.N;

import java.util.*;

public class NQueensII {
}

class Solution52 {
    private int size;
    private Set<Integer> diag;
    private Set<Integer> antiDiag;
    private Set<Integer> col;

    public int totalNQueens(int n) {
        size = n;
        diag = new HashSet<>();
        antiDiag = new HashSet<>();
        col = new HashSet<>();
        return backtrack(0);
    }

    private int backtrack(int row){
        if(row == size) return 1;

        int result = 0;
        for(int y = 0; y < size; y++){
            int curDiag = y - row;
            int curAntiDiag = row + y;
            if(col.contains(y) || diag.contains(curDiag) || antiDiag.contains(curAntiDiag)){
                continue;
            }

            col.add(y);
            diag.add(curDiag);
            antiDiag.add(curAntiDiag);

            result += backtrack(row + 1);

            col.remove(y);
            diag.remove(curDiag);
            antiDiag.remove(curAntiDiag);
        }
        return result;
    }
}