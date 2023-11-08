import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
}

class Solution105 {
    private HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    public TreeNode buildTree(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2){
        if(r1 - l1 < 0) return null;
        if(r1 - l1 == 0) return new TreeNode(preorder[l1]);

        int rootval = preorder[l1];
        TreeNode root = new TreeNode(rootval);
        int rootindex = map.get(rootval);
        root.left = buildTree(preorder, l1 + 1, l1 + (rootindex - l2), inorder, l2, rootindex - 1);
        root.right = buildTree(preorder, l1 + (rootindex - l2) + 1, r1, inorder, rootindex + 1, r2);
        return root;
    }
}