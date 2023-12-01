package Solution.B;

import java.util.*;

public class BitwiseORsOfSubarrays {
}

class Solution898 {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> current = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
            Set<Integer> newSet = new HashSet<>();
            newSet.add(arr[i]);
            for(int ele : current){
                newSet.add(ele | arr[i]);
            }
            result.addAll(newSet);
            current = newSet;
        }
        System.out.println(result);
        return result.size();
    }
}
