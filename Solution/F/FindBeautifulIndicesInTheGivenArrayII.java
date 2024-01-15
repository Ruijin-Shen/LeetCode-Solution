package Solution.F;

import Template.KMP;

import java.util.ArrayList;
import java.util.List;

public class FindBeautifulIndicesInTheGivenArrayII {
}

class Solution3008 {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> result = new ArrayList<>();
        List<Integer> aIndex = KMP.kmp(s, a);
        List<Integer> bIndex = KMP.kmp(s, b);
        if(bIndex.size() == 0) return result;

        for(int i : aIndex){
            int min = i - k;
            // binary search
            int left = 0, right = bIndex.size() -1;
            while(left < right){
                int mid = left + right >> 1;
                if(bIndex.get(mid) < min) left = mid + 1;
                else right = mid;
            }
            if(Math.abs(bIndex.get(left) - i) <= k) result.add(i);
        }
        return result;
    }
}