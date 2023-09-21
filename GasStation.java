public class GasStation {
}

class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int resiudal = 0;
        int start = 0;
        int fuel = 0;
        for(int i = 0; i < n; i++){
            fuel += gas[i] - cost[i];
            if(fuel < 0){
                resiudal += fuel;
                start = i + 1;
                fuel = 0;
            }
        }
        if(fuel + resiudal >= 0) return start;
        else return -1;
    }
}