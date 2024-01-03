package Solution.S;

public class SingleNumberIII {
}

class Solution260 {
    public int[] singleNumber(int[] nums) {
        int XOR = 0;
        for(int num : nums){
            XOR ^= num;
        }

        int lowbit = XOR & -XOR;

        int a = 0, b = 0;
        for(int num: nums){
            if((num & lowbit) == 0) a ^= num;
            else b ^= num;
        }
        return new int[]{a, b};
    }
}
