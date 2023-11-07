import java.util.*;
public class WordPattern {
}

class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        boolean[] alreadyMapped = new boolean[26];
        if(words.length != pattern.length()) return false;
        HashMap<String, Integer> mapping = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            String word = words[i];
            int ch = pattern.charAt(i) - 'a';
            if(mapping.containsKey(word)){
                if(mapping.get(word) != ch) return false;
            }else{
                if(alreadyMapped[ch]) return false;
                alreadyMapped[ch] = true;
                mapping.put(word, ch);
            }
        }
        return true;
    }
}