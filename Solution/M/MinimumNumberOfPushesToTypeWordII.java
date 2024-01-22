package Solution.M;

import java.util.ArrayList;
import java.util.Comparator;

public class MinimumNumberOfPushesToTypeWordII {
}

class Solution3016 {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        for(char ch : word.toCharArray()){
            count[ch - 'a']++;
        }
        ArrayList<Integer> freq = new ArrayList<>();
        for(int num : count){
            if(num != 0) freq.add(num);
        }

        freq.sort(Comparator.reverseOrder());
        int push = 0;
        int result = 0;
        for(int num : freq){
            result += (push / 8 + 1) * num;
            push++;
        }
        return result;
    }
}
