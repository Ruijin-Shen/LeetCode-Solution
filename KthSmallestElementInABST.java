public class KthSmallestElementInABST {
}

class Solution230 {
    private int result;

    public int kthSmallest(TreeNode root, int k) {
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