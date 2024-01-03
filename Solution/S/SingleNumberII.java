package Solution.S;

public class SingleNumberII {
}

class Solution137 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < 32; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                count += (nums[j] >> i) & 1;
            }
            result |= count % 3 == 0 ? 0 : (1 << i);
        }
        return result;
    }
}

class Solution137BitManipulation{
    public int singleNumber(int[] nums) {
        int a = 0, b = nums[0];
        for(int i = 1; i < nums.length; i++){
            b = (~a) & (b ^ nums[i]);
            a = (~b) & (a ^ nums[i]);
        }
        return b;
    }
}
