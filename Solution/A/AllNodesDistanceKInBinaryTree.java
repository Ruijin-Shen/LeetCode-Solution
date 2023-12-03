package Solution.A;
import Definition.TreeNode;

import java.sql.PreparedStatement;
import java.util.*;

public class AllNodesDistanceKInBinaryTree {
}

class Solution863MySolution {
    private List<Integer> result;
    private Deque<TreeNode> path;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        result = new LinkedList<>();
        path = new LinkedList<>();

        search(root, target);

        TreeNode prev = null;
        while(!path.isEmpty()){
            TreeNode node = path.removeLast();

            if(k == 0){
                result.add(node.val);
                break;
            }else{
                k--;
                if(node.left != prev) find(node.left, k);
                if(node.right != prev) find(node.right, k);
                prev = node;
            }
        }
        return result;
    }

    private boolean search(TreeNode root, TreeNode target){
        if(root == null) return false;

        if(root.val == target.val){
            path.addLast(root);
            return true;
        }

        path.addLast(root);
        if(search(root.left, target)) return true;
        if(search(root.right, target)) return true;
        path.removeLast();
        return false;
    }

    private void find(TreeNode root, int k){
        if(root == null) return;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        int depth = 0;
        while(!queue.isEmpty() && depth < k){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.removeFirst();
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
            }
            depth++;
        }
        for(TreeNode node : queue) result.add(node.val);
    }
}

class Solution863 {
    Map<Integer, List<Integer>> graph;
    List<Integer> answer;
    Set<Integer> visited;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        graph = new HashMap<>();
        graph.put(root.val, new ArrayList<>());
        buildGraph(root);

        answer = new ArrayList<>();
        visited = new HashSet<>();
        visited.add(target.val);

        dfs(target.val, 0, k);

        return answer;
    }

    private void buildGraph(TreeNode cur){
        if(cur == null) return;

        if(cur.left != null){
            graph.put(cur.left.val, new ArrayList<>());
            graph.get(cur.val).add(cur.left.val);
            graph.get(cur.left.val).add(cur.val);
            buildGraph(cur.left);
        }

        if(cur.right != null){
            graph.put(cur.right.val, new ArrayList<>());
            graph.get(cur.val).add(cur.right.val);
            graph.get(cur.right.val).add(cur.val);
            buildGraph(cur.right);
        }
    }

    private void dfs(int cur, int distance, int k){
        if(distance == k){
            answer.add(cur);
            return;
        }

        for(int v : graph.getOrDefault(cur, new ArrayList<>())){
            if(!visited.contains(v)){
                visited.add(v);
                dfs(v, distance + 1, k);
            }
        }
    }
}