package Solution.S;
import java.util.*;

public class SubstringWithConcatenationOfAllWords {
}

class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordsize = words[0].length();

        if(s.length() < wordsize * words.length) return result;

        for(int offset = 0; offset < wordsize; offset++){
            HashMap<String, Integer> count = new HashMap<>();
            for(String word : words){
                count.merge(word, 1, Integer::sum);
            }
            int nonezero = count.size();

            int left = offset, right = offset;
            if(words.length * wordsize + offset > s.length()) continue;
            while(right < words.length * wordsize + offset){
                right += wordsize;
                String substr = s.substring(right - wordsize, right);

                int val = count.merge(substr, -1, Integer::sum);
                if(val == 0) nonezero--;
                else if(val == -1) nonezero++;
            }

            while(right <= s.length()){
                if(nonezero == 0) result.add(left);

                // sliding windows
                String leftstr = s.substring(left, left + wordsize);
                int val = count.merge(leftstr, 1, Integer::sum);
                if(val == 0) nonezero--;
                else if(val == 1) nonezero++;
                left += wordsize;

                right += wordsize;
                if(right > s.length()) break;
                String rightstr = s.substring(right - wordsize, right);

                val = count.merge(rightstr, -1, Integer::sum);
                if(val == 0) nonezero--;
                else if(val == -1) nonezero++;
            }
        }
        return result;
    }
}