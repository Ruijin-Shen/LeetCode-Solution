import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElementII {
}

class Solution503MonotoneStack {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] numsCircular = new int[2 * n];
        int[] result = new int [2 * n];
        System.arraycopy(nums, 0, numsCircular, 0, n);
        System.arraycopy(nums, 0, numsCircular, n, n);

        Deque<Integer> monotoneStack = new LinkedList<>();
        for(int i = 2 * n - 1; i >= 0; i--){
            int curNum = numsCircular[i];
            while(!monotoneStack.isEmpty() && curNum > monotoneStack.getFirst()){
                monotoneStack.removeFirst();
            }
            if(monotoneStack.isEmpty()){
                result[i] = -1;
                monotoneStack.addFirst(numsCircular[i]);
            }else{
                result[i] = monotoneStack.getFirst();
                monotoneStack.addFirst(numsCircular[i]);
            }
        }

        return Arrays.copyOf(result, n);
    }
}
