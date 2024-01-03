package Solution.M;

public class MinimumSpeedToArriveOnTime {
}

class Solution1870BinarySearch {

    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 0, right = 10000001;
        while(left < right){
            int mid = left + right >> 1;
            if(evaluate(dist, mid, hour)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left == 10000001 ? -1 : left;
    }

    private boolean evaluate(int[] dist, int speed, double hour){
        int n = dist.length;
        double totalTime = 0;
        for(int i = 0; i < n - 1; i++){
            totalTime += Math.ceil((double)dist[i]/speed);
        }
        totalTime += (double)dist[n - 1]/speed;
        return totalTime <= hour;
    }
}
