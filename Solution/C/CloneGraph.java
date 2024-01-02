package Solution.C;

import java.util.*;

public class CloneGraph {
}

class Solution133 {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        return solve(node, new HashMap<>());
    }

    private Node solve(Node node, HashMap<Node, Node> copies){
        if(copies.containsKey(node)) return copies.get(node);
        Node newNode = new Node(node.val);
        copies.put(node, newNode);
        for(Node next : node.neighbors){
            newNode.neighbors.add(solve(next, copies));
        }
        return newNode;
    }
}
