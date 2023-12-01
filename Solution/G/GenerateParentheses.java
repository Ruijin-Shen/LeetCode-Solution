package Solution.G;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
}

class Solution22DFS {
    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new LinkedList<>();
        DFS(new StringBuilder(), n, 0, 0);
        return result;
    }

    private void DFS(StringBuilder builder, int n, int left, int right){
        if(left < n){
            builder.append('(');
            DFS(builder, n, left + 1, right);
            builder.deleteCharAt(builder.length() - 1);
        }
        if(right < n && right < left){
            builder.append(')');
            DFS(builder, n, left, right + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
        if(left == n && right == n){
            result.add(builder.toString());
        }
    }
}
