public class FindTheHighestAltitude {
}

class Solution1732 {
    public int largestAltitude(int[] gain) {
        int maxNum = 0;
        int n = gain.length;
        int curAlt = 0;
        for(int i = 1; i <= n; i++){
            curAlt = curAlt + gain[i - 1];
            maxNum = Math.max(maxNum, curAlt);
        }
        return maxNum;
    }
}
