package Solution.N;

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


class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int n = nums2.length;

        int[] index = new int[10001];
        int[] monotonicStack = new int[n];
        int[] fullResult = new int[n];
        int stackTop = -1;
        for(int i = n - 1; i >= 0; i--){
            int value = nums2[i];
            index[value] = i;
            while(stackTop >= 0 && monotonicStack[stackTop] <= value){
                stackTop--;
            }
            if(stackTop >= 0) fullResult[i] = monotonicStack[stackTop];
            else fullResult[i] = -1;
            monotonicStack[++stackTop] = value;
        }

        for(int i = 0; i < nums1.length; i++){
            result[i] = fullResult[index[nums1[i]]];
        }

        return result;
    }
}