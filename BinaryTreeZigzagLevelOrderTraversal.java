import Definition.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
}

class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int counter = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> layer = new ArrayList<>(size);
            for(int i = 0; i < size; i++){
                TreeNode node = queue.removeFirst();
                layer.add(node.val);
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
            }
            counter++;
            if(counter % 2 == 0) Collections.reverse(layer);
            result.add(layer);
        }
        return result;
    }
}