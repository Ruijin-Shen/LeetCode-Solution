package Solution.M;

import Definition.TreeNode;

public class MinimumAbsoluteDifferenceInBST {
}

class Solution530 {
    private int prevNode;
    private int result;

    public int getMinimumDifference(TreeNode root) {
        this.prevNode = -100000;
        this.result = 100000;

        traverse(root);
        return this.result;
    }

    private void traverse(TreeNode root){
        if(root == null) return;

        traverse(root.left);
        result = Math.min(result, root.val - prevNode);
        prevNode = root.val;
        traverse(root.right);
    }
}