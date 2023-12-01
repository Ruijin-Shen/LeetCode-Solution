import Definition.TreeNode;

public class BinaryTreeMaximumPathSum {
}

class Solution124 {
    private int result;

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        maxRtNSum(root);
        return result;
    }

    private int maxRtNSum(TreeNode root){
        if(root == null) return 0;

        int leftSum = Math.max(maxRtNSum(root.left), 0);
        int rightSum = Math.max(maxRtNSum(root.right), 0);
        int pathSum = leftSum + rightSum + root.val;
        result = Math.max(result, pathSum);
        return Math.max(leftSum, rightSum) + root.val;
    }
}