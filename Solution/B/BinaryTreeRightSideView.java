package Solution.B;

import Definition.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView {
}

class Solution199BFS {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        // BFS
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            result.add(queue.getLast().val);
            while(size > 0){
                TreeNode node = queue.removeFirst();
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
                size--;
            }
        }

        return result;
    }
}

class Solution199DFS {
    private Set<Integer> visit;
    private List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        visit = new HashSet<>();
        result = new ArrayList<>();
        if(root != null) DFS(root, 1);
        return result;
    }

    private void DFS(TreeNode root, int level){
        if(!visit.contains(level)){
            visit.add(level);
            result.add(root.val);
        }

        if(root.right != null) DFS(root.right, level + 1);
        if(root.left != null) DFS(root.left, level + 1);
    }
}