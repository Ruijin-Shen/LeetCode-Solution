package Solution.S;

import java.util.HashSet;

public class SumOfMatrixAfterQueries {
}

class Solution2718 {
    public long matrixSumQueries(int n, int[][] queries) {
        int num = queries.length;
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        long result = 0;
        for(int i = num - 1; i >= 0; i--){
            int[] query = queries[i];
            if(query[0] == 0){  // row
                if(row.contains(query[1])) continue;
                row.add(query[1]);
                result += (long) query[2] * (n - col.size());
            }else{
                if(col.contains(query[1])) continue;
                col.add(query[1]);
                result += (long) query[2] * (n - row.size());
            }
        }
        return result;
    }
}