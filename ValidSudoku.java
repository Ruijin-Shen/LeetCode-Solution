public class ValidSudoku {
}

class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        final int n = 9;
        final int dot = '.' - '0';
        for(int i = 0; i < n; i++){
            boolean[] row = new boolean[10];
            for(int j = 0; j < n; j++){
                int ch = board[i][j] - '0';
                if(ch == dot) continue;
                if(row[ch]) return false;
                row[ch] = true;
            }
        }

        for(int j = 0; j < n; j++){
            boolean[] col = new boolean[10];
            for(int i = 0; i < n; i++){
                int ch = board[i][j] - '0';
                if(ch == dot) continue;
                if(col[ch]) return false;
                col[ch] = true;
            }
        }

        for(int i = 0; i < n; i += 3){
            for(int j = 0; j < n; j += 3){
                boolean[] sq = new boolean[10];
                for(int p = 0; p < 3; p++){
                    for(int q = 0; q < 3; q++){
                        int ch = board[i + p][j + q] - '0';
                        if(ch == dot) continue;
                        if(sq[ch]) return false;
                        sq[ch] = true;
                    }
                }
            }
        }

        return true;
    }
}