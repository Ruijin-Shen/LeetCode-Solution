import java.util.*;

public class CombinationSum {
}

class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>>  result = new LinkedList<>();
        helper(candidates, 0, target, new LinkedList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int index, int target, LinkedList<Integer> combination, List<List<Integer>> result){
        int n = candidates.length;
        if(target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }
        if(index == n) return;

        if(target - candidates[index] >= 0){
            combination.addLast(candidates[index]);
            helper(candidates, index, target - candidates[index], combination, result);
            combination.removeLast();
        }

        helper(candidates, index + 1, target, combination, result);
    }
}