package Solution.M;

import java.util.*;

public class MaximumSumQueries {
}

class Solution2736MonotonicStack {
    public record Pair(int x, int y){
        public int sum(){return x + y;}
    }
    public record Query(int x, int y, int index){}
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length, m = queries.length;
        Pair[] pairs = new Pair[n + 1];
        Query[] qs = new Query[m];
        for(int i = 0; i < n; i++) pairs[i] = new Pair(nums1[i], nums2[i]);
        Arrays.sort(pairs, Comparator.comparing(Pair::x).reversed());
        pairs[n] = new Pair(Integer.MIN_VALUE, 0);
        for(int i = 0; i < m; i++) qs[i] = new Query(queries[i][0], queries[i][1], i);
        Arrays.sort(qs, Comparator.comparing(Query::x).reversed());

        ArrayList<Pair> stack = new ArrayList<>();
        int[] result = new int[m];
        int j = 0;
        for(int i = 0; i <= n; i++){
            Pair p = pairs[i];
            while(j < m && qs[j].x > p.x){
                // answer query
                Query q = qs[j];
                int yTarget = q.y;
                int left = 0, right = stack.size() - 1;
                while(left > right){ // binary search
                    int mid = left + right >> 1;
                    if(stack.get(mid).y < yTarget) left = mid + 1;
                    else right = mid;
                }
                if(!stack.isEmpty() && stack.get(left).y >= yTarget){
                    result[q.index] = stack.get(left).sum();
                }else{
                    result[q.index] = -1;
                }
                j++;
            }
            if(!stack.isEmpty() && p.y <= stack.get(stack.size() - 1).y){
                continue;
            }
            while(!stack.isEmpty() && p.sum() >= stack.get(stack.size() - 1).sum()){
                stack.remove(stack.size() - 1);
            }
            stack.add(p);
        }
        return result;
    }
}