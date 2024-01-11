package Solution.U;

import java.util.*;
import Definition.TreeNode;
public class UniqueBinarySearchTreesII {
}

class Solution95RecursiveDP {
    private List[][] dp;
    private static final List<TreeNode> empty = new ArrayList<>(){{add(null);}};

    public List<TreeNode> generateTrees(int n) {
        dp = new List[n + 1][n + 1];
        return construct(1, n);
    }

    private List<TreeNode> construct(int left, int right){
        if(left > right) return empty;
        if(dp[left][right] != null) return dp[left][right];

        List<TreeNode> result = new LinkedList<>();
        for(int i = left; i <= right; i++){
            for(TreeNode leftNode : construct(left, i - 1)){
                for(TreeNode rightNode : construct(i + 1, right)){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        dp[left][right] = result;
        return result;
    }
}


class Solution95IterativeDP {
    public List<TreeNode> generateTrees(int n){
        List<List<List<TreeNode>>> dp = new ArrayList<>(n + 1);
        for(int i = 0; i <= n; i++){
            List<List<TreeNode>> innerList = new ArrayList<>(n + 1);
            for(int j = 0; j <= n; j++){
                innerList.add(new ArrayList<>());
            }
            dp.add(innerList);
        }

        for(int i = 1; i <= n; i++){
            dp.get(i).get(i).add(new TreeNode(i));
        }

        for(int numberOfNodes = 2; numberOfNodes <= n; numberOfNodes++){
            for(int start = 1; start <= n - numberOfNodes + 1; start++){
                int end = start + numberOfNodes - 1;
                for(int i = start; i <= end; i++){
                    List<TreeNode> leftsub = (i == start) ? new ArrayList<>() : dp.get(start).get(i - 1);
                    if(leftsub.isEmpty()) leftsub.add(null);
                    List<TreeNode> rightsub = (i == end) ? new ArrayList<>() : dp.get(i + 1).get(end);
                    if(rightsub.isEmpty()) rightsub.add(null);

                    var list = dp.get(start).get(end);
                    for(TreeNode left : leftsub){
                        for(TreeNode right : rightsub){
                            TreeNode root = new TreeNode(i, left, right);
                            list.add(root);
                        }
                    }
                }
            }
        }
        return dp.get(1).get(n);
    }
}