package Solution.N;

import java.util.*;

public class NextGreaterElementIII {
}

class Solution556 {
    public int nextGreaterElement(int n) {
        char[] array = Integer.toString(n).toCharArray();
        int length = array.length;

        int prev = 0;
        for(int i = length - 1; i >= 0; i--){
            if(array[i] < prev){
                char curNum = array[i];
                Arrays.sort(array, i + 1, length);
                int left = i + 1, right = length - 1;
                while(left < right){
                    int mid = left + right >> 1;
                    if(array[mid] <= curNum) left = mid + 1;
                    else right = mid;
                }
                char temp = array[right];
                array[right] = (char)curNum;
                array[i] = temp;
                break;
            }else{
                prev = array[i];
            }
        }
        long result = Long.parseLong(String.valueOf(array));
        if(result == n || result > Integer.MAX_VALUE) return -1;
        else return (int)result;
    }
}