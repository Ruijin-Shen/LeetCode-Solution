package Solution.L;

import Definition.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
}

class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while(node != null){
            int result = compare(p, node) + compare(q, node);
            if(result == -2) node = node.left;
            else if(result == 2) node  = node.right;
            else return node;
        }
        return null;
    }

    private int compare(TreeNode a, TreeNode b){
        if(a == b) return 0;
        else return a.val - b.val < 0 ? -1 : 1;
    }
}