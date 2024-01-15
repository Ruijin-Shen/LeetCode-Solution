package Solution.W;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearchII {
}

class Solution212 {
    private static class TrieNode{
        public HashMap<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }

    private char[][] board;
    private List<String> result;
    private TrieNode root;
    private static final int[][] MOVE = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.result = new ArrayList<>();
        this.root = new TrieNode();

        for(String word : words){
            TrieNode node = root;

            for(char ch : word.toCharArray()){
                if(!node.children.containsKey(ch)) node.children.put(ch, new TrieNode());
                node = node.children.get(ch);
            }
            node.word = word;
        }

        for(int i = 0; i < this.board.length; i++){
            for(int j = 0; j < this.board[0].length; j++){
                if(root.children.containsKey(this.board[i][j])){
                    backtracking(i, j, root);
                }
            }
        }
        return result;
    }

    private void backtracking(int i, int j, TrieNode parent){
        char ch = this.board[i][j];
        TrieNode curNode = parent.children.get(this.board[i][j]);

        if(curNode.word != null){
            result.add(curNode.word);
            curNode.word = null;
        }

        this.board[i][j] = '*';
        for(int[] move : MOVE){
            int x = i + move[0], y = j + move[1];
            if(x >= 0 && x < this.board.length && y >= 0 && y < this.board[0].length && curNode.children.containsKey(this.board[x][y])){
                backtracking(x, y, curNode);
            }
        }
        this.board[i][j] = ch;
        if(curNode.children.isEmpty()){
            parent.children.remove(ch);
        }
    }
}