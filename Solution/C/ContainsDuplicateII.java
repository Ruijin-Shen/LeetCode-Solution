package Solution.C;

import java.util.HashMap;

public class ContainsDuplicateII {
}

class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(i - index.getOrDefault(num, -100000) <= k) return true;
            index.put(num, i);
        }
        return false;
    }
}