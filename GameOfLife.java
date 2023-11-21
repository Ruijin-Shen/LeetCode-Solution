public class GameOfLife {
}

class Solution289 {
    public void gameOfLife(int[][] board) {
        int[] neighbors = {0, 1, -1};

        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                int count = 0;
                for(int r = 0; r < 3; r++){
                    for(int c = 0; c < 3; c++){
                        if(r == 0 && c == 0) continue;
                        int x = i + neighbors[r];
                        int y = j + neighbors[c];

                        if(x < rows && x >= 0 && y < cols && y >= 0 && Math.abs(board[x][y]) == 1){
                            count++;
                        }
                    }
                }

                if(board[i][j] == 1 && (count < 2 || count > 3)) board[i][j] = -1;
                if(board[i][j] == 0 && count == 3) board[i][j] = 2;
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] > 0) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
    }
}