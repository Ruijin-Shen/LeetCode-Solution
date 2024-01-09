package Solution.M;

import java.util.HashMap;

public class MinimumWindowSubstring {
}

class Solution76 {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        HashMap<Character, Integer> count = new HashMap<>();
        for(char ch : t.toCharArray()){
            count.merge(ch, 1, Integer::sum);
        }
        int required = count.size();

        int i = 0, j = 0, left = 0, length = Integer.MAX_VALUE;
        for(j = 0; required > 0 && j < m; j++){
            char ch = s.charAt(j);
            count.merge(ch, -1, Integer::sum);
            if(count.get(ch) == 0) required--;
        }
        if(required > 0) return "";

        for(; j <= m; j++){
            while(count.get(s.charAt(i)) < 0){
                count.merge(s.charAt(i), 1, Integer::sum);
                i++;
            }
            if(j - i < length){
                length = j - i;
                left = i;
            }
            if(j < m) count.merge(s.charAt(j), -1, Integer::sum);
        }
        return s.substring(left, left + length);
    }
}