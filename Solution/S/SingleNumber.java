package Solution.S;

public class SingleNumber {
}

class Solution136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums){
            result = result ^ i;
        }
        return result;
    }
}
