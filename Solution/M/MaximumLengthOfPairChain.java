package Solution.M;

import java.util.*;

public class MaximumLengthOfPairChain {
}

class Solution646 {
    public int findLongestChain(int[][] pairs) {
        int endNum = Integer.MIN_VALUE;
        int result = 0;
        Arrays.sort(pairs, (x, y) -> x[1] - y[1]);

        for(int[] pair : pairs){
            if(pair[0] > endNum){
                result++;
                endNum = pair[1];
            }
        }
        return result;
    }
}