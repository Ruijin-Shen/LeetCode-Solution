package Solution.I;

import java.util.*;

public class IsomorphicStrings {
}

class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> alreadyMapped = new HashSet<>();
        for(int i = 0; i < n; i++){
            char a = s.charAt(i), b = t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a) != b) return false;
            }else{
                if(alreadyMapped.contains(b)) return false;
                map.put(a, b);
                alreadyMapped.add(b);
            }
        }
        return true;
    }
}