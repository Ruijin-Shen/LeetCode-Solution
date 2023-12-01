package Solution.E;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {
}

class Solution2352 {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        Map<String, Integer> rowCounter = new HashMap<>();
        for(int[] row : grid){
            String rowString = Arrays.toString(row);
            rowCounter.put(rowString, 1 + rowCounter.getOrDefault(rowString, 0));
        }

        for(int c = 0; c < n; c++){
            int[] col = new int[n];
            for(int r = 0; r < n; r++){
                col[r] = grid[r][c];
            }
            count += rowCounter.getOrDefault(Arrays.toString(col), 0);
        }
        return count;
    }
}

class TrieNodeInt{
    int count;
    Map<Integer, TrieNodeInt> children;

    public TrieNodeInt(){
        this.count = 0;
        this.children = new HashMap<>();
    }
}

class TrieInt{
    TrieNodeInt trie;

    public TrieInt(){
        this.trie = new TrieNodeInt();
    }

    public void insert(int[] array){
        TrieNodeInt root = this.trie;
        for(int a : array){
            if(!root.children.containsKey(a)){
                root.children.put(a, new TrieNodeInt());
            }
            root =  root.children.get(a);
        }
        root.count += 1;
    }

    public int search(int[] array){
        TrieNodeInt root = this.trie;
        for(int a : array){
            if(!root.children.containsKey(a)) return 0;
            root = root.children.get(a);
        }

        return root.count;
    }
}

class Solution2352Trie {
    public int equalPairs(int[][] grid) {
        TrieInt trie = new TrieInt();
        int count = 0;
        int n = grid.length;

        for(int[] row : grid){
            trie.insert(row);
        }

        for(int c = 0; c < n; c++){
            int[] array = new int[n];
            for(int r = 0; r < n; r++){
                array[r] = grid[r][c];
            }
            count += trie.search(array);
        }

        return count;
    }
}



