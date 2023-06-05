import java.util.HashSet;
import java.util.stream.Collectors;


public class MinimizeStringLength {
}

class Solution2716 {
    public int minimizedStringLength(String s) {
        boolean[] count = new boolean[26];
        for(char c : s.toCharArray()){
            count[c - 'a'] = true;
        }
        int result = 0;
        for(int i = 0; i < 26; i++){
            if(count[i]) result++;
        }
        return result;
    }
}

class Solution2716_Stream {
    public int minimizedStringLength(String s) {
        return s.chars().mapToObj(e -> (char) e).collect(Collectors.toCollection(HashSet::new)).size();
    }
}

