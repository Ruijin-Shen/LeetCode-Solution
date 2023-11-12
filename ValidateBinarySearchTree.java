import java.util.*;

public class ValidateBinarySearchTree {
}

class Solution98Recursion {
    private long prev;

    public boolean isValidBST(TreeNode root) {
        prev = Long.MIN_VALUE;
        return DFS(root);
    }

    public boolean DFS(TreeNode root){
        if(root == null) return true;

        if(!DFS(root.left)) return false;
        if(root.val <= prev) return false;
        else prev = root.val;
        if(!DFS(root.right)) return false;

        return true;
    }
}

class Solution98Stack {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        long prev = Long.MIN_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        stackPush(stack, root);

        while(!stack.isEmpty()){
            TreeNode node = stack.removeLast();
            if(node.val <= prev) return false;
            else prev = node.val;

            stackPush(stack, node.right);
        }
        return true;
    }

    private void stackPush(Deque<TreeNode> stack, TreeNode node){
        while(node != null){
            stack.addLast(node);
            node = node.left;
        }
    }
}