import Definition.TreeNode;

public class SumRootToLeafNumbers {
}

class Solution129DFS {
    private int result = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int num){
        num = num * 10 + root.val;

        if(root.left == null && root.right == null){
            result += num;
            return;
        }

        if(root.left != null) helper(root.left, num);
        if(root.right != null) helper(root.right, num);
    }
}
