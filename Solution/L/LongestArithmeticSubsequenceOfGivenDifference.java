package Solution.L;

import java.util.HashMap;

public class LongestArithmeticSubsequenceOfGivenDifference {
}

class Solution1218 {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();

        int result = 0;
        for(int num : arr){
            int prev = num - difference;
            int length = dp.getOrDefault(prev, 0) + 1;
            if(length > result) result = length;
            dp.put(num, length);
        }

        return result;
    }
}