package Solution.A;

public class AntOnTheBoundary {
}

class Solution3028 {
    public int returnToBoundaryCount(int[] nums) {
        int result = 0;
        int position = 0;
        for(int move : nums){
            position += move;
            if(position == 0) result++;
        }
        return result;
    }
}