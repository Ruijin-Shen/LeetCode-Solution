import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class NextGreaterElementI {
}


class Solution486MonotoneStack {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> monotoneStack = new LinkedList<>();
        for(int i = nums2.length - 1; i >= 0; i--){
            int curNum = nums2[i];
            while(!monotoneStack.isEmpty() && curNum > monotoneStack.getFirst()){
                monotoneStack.removeFirst();
            }
            if(monotoneStack.isEmpty()){
                map.put(nums2[i], -1);
                monotoneStack.addFirst(nums2[i]);
            }else{
                map.put(nums2[i], monotoneStack.getFirst());
                monotoneStack.addFirst(nums2[i]);
            }
        }

        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}