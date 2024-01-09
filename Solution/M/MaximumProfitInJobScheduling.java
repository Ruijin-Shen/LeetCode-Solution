package Solution.M;

import java.util.*;

public class MaximumProfitInJobScheduling {
}

class Solution1235DP {
    public record Job(int startTime, int endTime, int profit){}
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for(int i = 0; i < n; i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparing(Job::endTime));
        int[] profits = new int[n];
        profits[0] = jobs[0].profit;
        for(int i = 1; i < n; i++){
            profits[i] = profits[i - 1];
            int start = jobs[i].startTime;
            int left = 0, right = i - 1;
            while(left < right){ // binary search
                int mid = (left + right + 1) >> 1;
                if(jobs[mid].endTime <= start) left = mid;
                else right = mid - 1;
            }
            profits[i] = Math.max(profits[i], (jobs[left].endTime <= start ? profits[left] : 0) + jobs[i].profit);
        }
        return profits[n - 1];
    }
}

class Solution1235PriorityQueue{
    public record Job(int startTime, int endTime, int profit){}
    public record Chain(int endTime, int profit){}
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<Job> jobs = new ArrayList<>();
        for(int i = 0; i < n; i++){
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        jobs.sort(Comparator.comparing(Job::startTime));

        int maxProfit = 0;
        PriorityQueue<Chain> pq = new PriorityQueue<>(Comparator.comparing(Chain::endTime));
        for(int i = 0; i < n; i++){
            Job curJob = jobs.get(i);
            while(!pq.isEmpty() && curJob.startTime >= pq.peek().endTime){
                maxProfit = Math.max(maxProfit, pq.remove().profit);
            }
            pq.add(new Chain(curJob.endTime, curJob.profit + maxProfit));
        }

        while(!pq.isEmpty()){
            maxProfit = Math.max(maxProfit, pq.remove().profit);
        }
        return maxProfit;
    }
}
