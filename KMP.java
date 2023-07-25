import java.util.ArrayList;
import java.util.List;

public class KMP {
    private static int[] next;

    private static void getNext(String pattern){
        int n = pattern.length();
        next = new int[n];
        for(int i = 1, j = 0; i < n; i++){
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = next[j - 1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }

    public static List<Integer> kmp(String origin, String pattern){
        getNext(pattern);
        int m = origin.length(), n = pattern.length();
        List<Integer> result = new ArrayList<>();
        // 字符串匹配
        for(int i = 0, j = 0; i < m; i++){
            while(j > 0 && origin.charAt(i) != pattern.charAt(j)){
                j = next[j - 1];
            }
            if(origin.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if(j == n){ // 匹配成功
                j = next[j - 1];
                result.add(i - n + 1);
            }
        }
        return result;
    }
}
