import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NumberOfWaysToReorderArraytoGetSameBST {
}

class Solution1659 {
    private static final Combination combination = new Combination((long)1e9+7, 1000);


    public int numOfWays(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().toList();
        return (int)(helper(numsList) - 1);
    }

    public long helper(List<Integer> nums){
        int n = nums.size();
        if(n <= 2) return 1;

        int root = nums.get(0);
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();

        for(int i : nums){
            if(i < root){
                left.add(i);
            }
            if(i > root){
                right.add(i);
            }
        }
        long leftCount = helper(left);
        long rightCount = helper(right);


        long result = ((leftCount * rightCount) % (1000000007) * combination.combination(left.size()+right.size(), left.size())) % (1000000007);
        return result;
    }
}
