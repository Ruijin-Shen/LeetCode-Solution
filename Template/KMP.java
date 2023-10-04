package Template;

import java.util.*;

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

    /**
     * Time complexity: O(m) preprocessing + O(n) matching
     * @param origin
     * @param pattern
     * @return the index of patttern in origin
     */
    public static List<Integer> kmp(String origin, String pattern){
        getNext(pattern);
        int m = origin.length(), n = pattern.length();
        List<Integer> result = new ArrayList<>();
        // String matching
        for(int i = 0, j = 0; i < m; i++){
            while(j > 0 && origin.charAt(i) != pattern.charAt(j)){
                j = next[j - 1];
            }
            if(origin.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if(j == n){ // Matching successful!
                j = next[j - 1];
                result.add(i - n + 1);
            }
        }
        return result;
    }
}