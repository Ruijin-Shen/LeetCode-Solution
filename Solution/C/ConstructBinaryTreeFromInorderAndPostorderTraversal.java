package Solution.C;

import Definition.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
}

class Solution106 {
    private HashMap<Integer, Integer> index = new HashMap();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int i = 0;
        for(int val : inorder) index.put(val, i++);
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2){
        if(l1 > r1) return null;

        int rootVal = postorder[r2];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = index.get(rootVal);
        int leftSize = rootIndex - l1;
        root.left = buildTree(inorder, l1, rootIndex - 1, postorder, l2, l2 + leftSize - 1);
        root.right = buildTree(inorder, rootIndex + 1, r1, postorder, l2 + leftSize, r2 - 1);
        return root;
    }
}