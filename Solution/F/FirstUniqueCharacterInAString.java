package Solution.F;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {
}

class Solution387 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for(char ch : s.toCharArray()){
            count.merge(ch, 1, Integer::sum);
        }
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(count.get(ch) == 1) return i;
        }
        return -1;
    }
}