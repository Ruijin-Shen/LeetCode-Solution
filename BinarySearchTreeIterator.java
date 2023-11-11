import java.util.*;

public class BinarySearchTreeIterator {
}

class BSTIterator {
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        if(root != null) this.pushNode(root);
    }

    public int next() {
        TreeNode node = stack.removeLast();
        if(node.right != null) this.pushNode(node.right);
        return node.val;
    }

    private void pushNode(TreeNode root){
        while(root != null){
            stack.addLast(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}