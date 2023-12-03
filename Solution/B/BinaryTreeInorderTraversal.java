package Solution.B;

import java.util.*;
import Definition.TreeNode;

public class BinaryTreeInorderTraversal {
}

class Solution94 {
    List<Integer> result;

    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root){
        if(root == null) return;

        dfs(root.left);
        result.add(root.val);
        dfs(root.right);
    }
}