package Solution.B;

import Definition.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
}

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.removeFirst();
                layer.add(node.val);
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
            }
            result.add(layer);
        }
        return result;
    }
}