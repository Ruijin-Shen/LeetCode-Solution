package Solution.L;

import java.util.HashSet;

public class LongestConsecutiveSequence {
}

class Solution128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        int result = 0;
        for(int num : set){
            if(set.contains(num - 1)) continue;

            int curNum = num;
            int curLength = 1;
            while(set.contains(curNum + 1)){
                curNum++;
                curLength++;
            }
            if(curLength > result) result = curLength;
        }
        return result;
    }
}