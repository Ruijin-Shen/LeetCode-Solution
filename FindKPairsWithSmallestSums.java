import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import static java.util.Arrays.asList;

class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new LinkedList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Arrays::compare);
        int base = nums2[0];
        int n = nums1.length, m = nums2.length;
        for(int i = 0; i < n; i++){
            queue.add(new int[]{nums1[i] + base, i, 0});
        }

        while(k > 0 && !queue.isEmpty()){
            int[] nextPair = queue.remove();
            result.add(asList(nums1[nextPair[1]], nums2[nextPair[2]]));
            k--;
            if(nextPair[2] + 1 < m){
                queue.add(new int[]{nums1[nextPair[1]] + nums2[nextPair[2] + 1],
                        nextPair[1], nextPair[2] + 1});
            }
        }

        return result;
    }
}