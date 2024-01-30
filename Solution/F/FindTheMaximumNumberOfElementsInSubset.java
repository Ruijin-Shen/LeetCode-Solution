package Solution.F;

import java.util.Arrays;
import java.util.HashMap;

public class FindTheMaximumNumberOfElementsInSubset {
}

class Solution3020 {
    private static final int[] EMPTY = new int[]{0, 0};
    public int maximumLength(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        int one = 0;
        HashMap<Integer, int[]> map = new HashMap<>();
        for(int num : nums){
            if(num == 1){
                one++;
                continue;
            }
            if(!map.containsKey(num)) map.put(num, new int[]{0, 0});
            map.get(num)[0]++;

            int sqrt = (int)Math.sqrt(num);
            if(sqrt * sqrt == num && map.getOrDefault(sqrt, EMPTY)[0] >= 2){
                int length = 1 + map.get(sqrt)[1];
                result = Math.max(result, length);
                map.get(num)[1] = length;
            }
        }
        if(one % 2 == 0){
            one--;
        }
        return Math.max(one, result * 2 + 1);
    }
}