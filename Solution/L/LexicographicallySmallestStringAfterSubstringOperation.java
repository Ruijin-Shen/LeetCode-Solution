package Solution.L;

public class LexicographicallySmallestStringAfterSubstringOperation {
}

class Solution2734 {
    public String smallestString(String s) {
        int n = s.length();
        StringBuilder builder = new StringBuilder(s);
        int start;
        for(start = 0; start < n - 1; start++){
            if(builder.charAt(start) != 'a'){
                break;
            }
        }

        builder.setCharAt(start, builder.charAt(start) == 'a' ? 'z' : (char)(builder.charAt(start) - 1));
        for(int i = start + 1; i < n; i++){
            if(builder.charAt(i) == 'a') break;
            builder.setCharAt(i, (char)(builder.charAt(i) - 1));
        }
        return builder.toString();
    }
}
