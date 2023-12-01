package Solution.H;

import java.util.*;

public class HIndex {
}

class Solution274 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        int result = 0;
        for(int i = n - 1; i >= 0; i--){
            if(citations[i] >= result + 1){
                result++;
            }else{
                break;
            }
        }
        return result;
    }
}