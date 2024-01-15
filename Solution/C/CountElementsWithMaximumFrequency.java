package Solution.C;

import java.util.HashMap;

public class CountElementsWithMaximumFrequency {
}

class Solution3005 {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num : nums) count.merge(num, 1, Integer::sum);
        int maxF = 0, n = 0;
        for(var entry : count.entrySet()){
            if(entry.getValue() > maxF){
                maxF = entry.getValue();
                n = 1;
            }else if(entry.getValue() == maxF){
                n++;
            }
        }
        return maxF * n;
    }
}