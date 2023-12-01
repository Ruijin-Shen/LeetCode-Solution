import Definition.TreeNode;

import java.util.*;

public class PathSum {
}

class Solution112Recursion {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return DFS(root, 0, targetSum);
    }

    private boolean DFS(TreeNode root, int sum, int targetSum){
        if(root == null) return false;
        if(root.left == null && root.right == null) return (sum + root.val) == targetSum;

        if(DFS(root.left, sum + root.val, targetSum)) return true;
        if(DFS(root.right, sum + root.val, targetSum)) return true;
        return false;
    }
}

class Solution112Stack {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> sumStack = new LinkedList<>();
        nodeStack.addLast(root);
        sumStack.addLast(root.val);

        TreeNode node = null;
        int curSum = 0;
        while(!nodeStack.isEmpty()){
            node = nodeStack.removeLast();
            curSum = sumStack.removeLast();
            if((node.right == null) && (node.left == null) && (curSum == targetSum)){
                return true;
            }

            if(node.right != null){
                nodeStack.addLast(node.right);
                sumStack.addLast(curSum + node.right.val);
            }

            if(node.left != null){
                nodeStack.addLast(node.left);
                sumStack.addLast(curSum + node.left.val);
            }
        }
        return false;
    }
}