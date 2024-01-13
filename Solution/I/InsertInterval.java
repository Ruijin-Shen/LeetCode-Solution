package Solution.I;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
}

class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        boolean flag = false;
        for(int i = 0; i < n; i++){
            int[] itv = intervals[i];
            if(flag || itv[1] < newInterval[0]){
                result.add(itv);
            }else{
                if(itv[0] > newInterval[1]){
                    flag = true;
                    result.add(newInterval);
                    result.add(itv);
                }else{
                    flag = true;
                    int[] insert = new int[]{Math.min(itv[0], newInterval[0]), Math.max(itv[1], newInterval[1])};
                    while(i + 1 < n && insert[1] >= intervals[i + 1][0]){
                        insert[1] = Math.max(insert[1], intervals[i + 1][1]);
                        i++;
                    }
                    result.add(insert);
                }
            }
        }
        if(!flag) result.add(newInterval);
        return result.toArray(int[][]::new);
    }
}