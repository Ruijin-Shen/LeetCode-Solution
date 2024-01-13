package Solution.S;

import Definition.TreeNode;

public class SymmetricTree {
}

class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode left, TreeNode right){
        if(left == null) return right == null;
        if(right == null) return false;

        return left.val == right.val && isSame(left.left, right.right) && isSame(left.right, right.left);
    }
}