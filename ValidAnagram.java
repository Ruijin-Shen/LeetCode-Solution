import java.util.Arrays;

public class ValidAnagram {
}

class Solution242 {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray(), tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return String.valueOf(sArr).equals(String.valueOf(tArr));
    }
}
