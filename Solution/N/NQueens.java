package Solution.N;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
}

class Solution51DFS {
    private List<List<String>> result;
    private StringBuilder builder = new StringBuilder();

    public List<List<String>> solveNQueens(int n) {
        this.result = new LinkedList<>();
        for(int i = 0; i < n; i++) builder.append(".");

        DFS(n, new int[n], 0);
        return result;
    }

    private void DFS(int n, int[] position, int depth){
        if(depth == n){
            List<String> list = new ArrayList<>(n);
            for(int i = 0; i < n; i++){
                builder.setCharAt(position[i], 'Q');
                list.add(builder.toString());
                builder.setCharAt(position[i], '.');
            }
            result.add(list);
            return;
        }

        for(int i = 0; i < n; i++){
            boolean flag = true;
            for(int j = 0; j < depth; j++){
                if(position[j] == i || j - position[j] == depth - i || j + position[j] == depth + i){
                    flag = false;
                    break;
                }
            }
            if(flag){
                position[depth] = i;
                DFS(n, position, depth + 1);
            }
        }
    }
}
