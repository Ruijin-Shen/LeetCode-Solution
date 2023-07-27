public class CorporateFlightBookings {
}

class Solution1109 {
    private int[] diff;

    public int[] corpFlightBookings(int[][] bookings, int n) {
        diff = new int[n + 2];
        for(int[] booking : bookings){
            diff[booking[0]] += booking[2];
            diff[booking[1] + 1] -= booking[2];
        }

        int[] result = new int[n];
        int acc = 0;
        for(int i = 0; i < n; i++){
            acc += diff[i + 1];
            result[i] = acc;
        }

        return result;
    }
}
