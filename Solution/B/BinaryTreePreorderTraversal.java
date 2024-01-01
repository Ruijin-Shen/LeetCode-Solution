package Solution.B;

import Definition.TreeNode;
import java.util.*;

public class BinaryTreePreorderTraversal {
}

class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        DFS(root, result);
        return result;
    }

    private void DFS(TreeNode node, List<Integer> result){
        if(node == null) return;
        result.add(node.val);
        DFS(node.left, result);
        DFS(node.right, result);
    }
}