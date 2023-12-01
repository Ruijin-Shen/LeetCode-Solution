import Definition.TreeNode;

public class SameTree {
}

class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == q) return true;  // including null.
        if(p == null || q == null) return false;

        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}