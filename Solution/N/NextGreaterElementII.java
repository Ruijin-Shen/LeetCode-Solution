package Solution.N;

import java.util.Arrays;

public class NextGreaterElementII {
    public static void main(String[] args) {
        Solution503MonotoneStack s = new Solution503MonotoneStack();
        s.nextGreaterElements(new int[]{1,2,1});
    }
}

class Solution503MonotoneStack {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[2 * n];

        int[] monotonicStack = new int[2 * n];
        int stackTop = -1;
        for(int i = 2 * n - 1; i >= 0; i--){
            int value = nums[i % n];
            if(stackTop >= 0 && monotonicStack[stackTop] <= value){
                stackTop--;
            }
            if(stackTop >= 0) result[i] = monotonicStack[stackTop];
            else result[i] = -1;
            monotonicStack[++stackTop] = value;
        }
        return Arrays.copyOf(result, n);
    }
}