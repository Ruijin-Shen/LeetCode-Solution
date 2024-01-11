package Solution.T;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
}

class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> prev = new ArrayList<>(triangle.get(n - 1));
        List<Integer> cur = new ArrayList<>(prev);
        for(int i = n - 2; i >= 0; i--){
            List<Integer> row = triangle.get(i);
            for(int j = 0; j <= i; j++){
                cur.set(j, row.get(j) + Math.min(prev.get(j), prev.get(j + 1)));
            }
            var temp = prev;
            prev = cur;
            cur = temp;
        }
        return prev.get(0);
    }
}