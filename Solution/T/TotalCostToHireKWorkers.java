package Solution.T;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {
}

class Solution2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int left = candidates - 1, right = n - candidates;
        long cost = 0;

        PriorityQueue<int[]> leftQueue = new PriorityQueue<>(Arrays::compare);
        PriorityQueue<int[]> rightQueue = new PriorityQueue<>(Arrays::compare);
        if(right - left > 1){
            for(int i = 0; i <= left; i++){
                leftQueue.add(new int[]{costs[i],i});
            }
            for(int i = n - 1; i >= right; i--){
                rightQueue.add(new int[]{costs[i], i});
            }

            while(right - left > 1 && k > 0){
                int[] leftMin = leftQueue.element(), rightMin = rightQueue.element();
                if(Arrays.compare(leftMin, rightMin) < 0) {
                    cost += leftMin[0];
                    leftQueue.remove();
                    left ++;
                    leftQueue.add(new int[]{costs[left], left});
                }else{
                    cost += rightMin[0];
                    rightQueue.remove();
                    right--;
                    rightQueue.add(new int[]{costs[right], left});
                }
                k--;
            }
        }else{
            for(int i = 0; i < n; i++){
                leftQueue.add(new int[]{costs[i], i});
            }
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Arrays::compare);
        queue.addAll(leftQueue);
        queue.addAll(rightQueue);

        while(k > 0){
            cost += queue.remove()[0];
            k--;
        }

        return cost;
    }
}
