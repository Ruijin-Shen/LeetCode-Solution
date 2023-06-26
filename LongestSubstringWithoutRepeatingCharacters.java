import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) return 0;
        HashMap<Character, Integer> index = new HashMap<>();

        int result = 1;
        index.put(s.charAt(0), 0);
        int j = 0;
        for(int i = 1; i < n; i++){
            if(index.containsKey(s.charAt(i)) && index.get(s.charAt(i)) >= j){
                j = index.get(s.charAt(i)) + 1;
            }
            index.put(s.charAt(i), i);
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}