package Solution.L;

import Definition.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
}

class Solution236 {
    private TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        result = null;
        DFS(root, p, q);
        return result;
    }

    private int DFS(TreeNode root, TreeNode p, TreeNode q){
        int sum = 0;
        if(root.left != null && DFS(root.left, p, q) != 0) sum++;
        if(root == p || root == q) sum++;
        if(root.right != null && DFS(root.right, p, q) != 0) sum++;

        if(sum == 2) this.result = root;
        return sum > 0 ? 1 : 0;
    }
}