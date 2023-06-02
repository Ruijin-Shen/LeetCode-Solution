import java.util.HashMap;

public class TwoSum {
}


class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> lookupTable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (lookupTable.containsKey(target - nums[i])) {
                return new int[]{lookupTable.get(target - nums[i]), i};
            }
            lookupTable.put(nums[i], i);
        }
        return new int[0];
    }
}
