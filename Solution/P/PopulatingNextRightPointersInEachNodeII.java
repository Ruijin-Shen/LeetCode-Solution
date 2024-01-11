package Solution.P;

import java.util.*;

public class PopulatingNextRightPointersInEachNodeII {
}

class Solution117 {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        Node curNode = root;
        Node nextLevelNode = null;
        Node nextLevelStart = null;

        while(curNode != null){
            if(curNode.left != null){
                if(nextLevelNode != null){
                    nextLevelNode.next = curNode.left;
                }
                nextLevelNode = curNode.left;
                if(nextLevelStart == null) nextLevelStart = curNode.left;
            }
            if(curNode.right != null){
                if(nextLevelNode != null){
                    nextLevelNode.next = curNode.right;
                }
                nextLevelNode = curNode.right;
                if(nextLevelStart == null) nextLevelStart = curNode.right;
            }

            curNode = curNode.next;
            if(curNode == null){
                curNode = nextLevelStart;
                nextLevelNode = nextLevelStart = null;
            }
        }
        return root;
    }
}

class Solution117BFS {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if(root == null) return root;
        Deque<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.removeFirst();
                if(i < size - 1) node.next = queue.peekFirst();
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
            }
        }
        return root;
    }
}