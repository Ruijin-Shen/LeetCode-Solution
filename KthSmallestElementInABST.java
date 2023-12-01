import Definition.TreeNode;

import java.util.*;

public class KthSmallestElementInABST {
}

class Solution230 {
    private int result;

    public int kthSmallest230Recursion(TreeNode root, int k) {
        DFS(root, k, 0);
        return result;
    }

    private int DFS(TreeNode root, int k, int count){
        if(root == null) return 0;
        int left = DFS(root.left, k, count);
        if(left + count >= k) return left + 1;
        if(left + count + 1 == k){
            this.result = root.val;
            return left + 1;
        }
        int right = DFS(root.right, k, count + left + 1);
        return left + 1 + right;
    }
}

class Solution230Stack {
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while(true){
            while(root != null){
                stack.addLast(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(--k == 0) return root.val;
            root = root.right;
        }
    }
}