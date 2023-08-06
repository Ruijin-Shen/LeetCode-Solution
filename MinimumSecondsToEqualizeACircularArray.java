import java.util.*;

public class MinimumSecondsToEqualizeACircularArray {
}

class Solution2808 {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, ArrayList<Integer>> position = new HashMap<>();

        int index = 0;
        for(int num : nums){
            if(!position.containsKey(num)){
                position.put(num, new ArrayList<>());
            }
            position.get(num).add(index);
            index++;
        }


        int result = n / 2;
        for(ArrayList<Integer> list : position.values()){
            if(list.size() == 1) continue;

            list.add(list.get(0) + n);
            int maxGap = 0;
            int prev = list.get(0);
            for(int i = 1; i < list.size(); i++){
                int current = list.get(i);
                maxGap = Math.max(maxGap, current - prev - 1);
                prev = current;
            }
            result = Math.min(result, (maxGap + 1) / 2);
        }
        return result;
    }
}