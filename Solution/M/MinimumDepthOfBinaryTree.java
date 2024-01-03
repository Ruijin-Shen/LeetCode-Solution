package Solution.M;

import Definition.TreeNode;

import java.util.*;

public class MinimumDepthOfBinaryTree {
}

class Solution111BFS {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        int depth = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0; i < n; i++){
                TreeNode node = queue.removeFirst();
                if(node.left == null && node.right == null) return depth;
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
            }
            depth++;
        }

        return depth;
    }
}