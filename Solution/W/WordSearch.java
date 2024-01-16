package Solution.W;

public class WordSearch {
}

class Solution79 {
    private static final int[][] MOVE = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(backtrack(i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(int i, int j, String word, int index){
        char ch = board[i][j];
        if(index == word.length() - 1) return word.charAt(index) == ch;
        if(word.charAt(index) != ch) return false;

        board[i][j] = '*';
        for(int[] move : MOVE){
            int x = i + move[0], y = j + move[1];
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != '*' && backtrack(x, y, word, index + 1)) return true;
        }
        board[i][j] = ch;
        return false;
    }
}