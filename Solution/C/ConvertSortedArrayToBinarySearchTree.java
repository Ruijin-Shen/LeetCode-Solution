package Solution.C;

import Definition.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
}

class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int left, int right){
        if(left > right) return null;

        int mid = left + right >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = construct(nums, left, mid - 1);
        root.right = construct(nums, mid + 1, right);
        return root;
    }
}