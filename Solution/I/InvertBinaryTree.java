package Solution.I;

import Definition.TreeNode;

public class InvertBinaryTree {
}

class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}