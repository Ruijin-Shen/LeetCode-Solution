package Solution.R;

import java.util.*;

public class ReverseWordsInAString {
}
class Solution151 {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> words = Arrays.asList(s.split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }
}
