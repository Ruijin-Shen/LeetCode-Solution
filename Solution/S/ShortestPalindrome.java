package Solution.S;

public class ShortestPalindrome {
}

class Solution214KMP {
    public String shortestPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[] next = getNext(s);

        int i, j;
        for(i = 0, j = 0; i < n; i++){
            while(j > 0 && reverse.charAt(i) != s.charAt(j)) j = next[j - 1];
            if(reverse.charAt(i) == s.charAt(j)){
                j++;
            }
        }

        StringBuilder builder = new StringBuilder(reverse);
        builder.append(s.substring(j));
        return builder.toString();
    }

    private int[] getNext(String origin){
        int n = origin.length();
        int[] next = new int[n];

        for(int i = 1, j = 0; i < n; i++){
            while(j > 0 && origin.charAt(i) != origin.charAt(j)) j = next[j - 1];
            if(origin.charAt(i) == origin.charAt(j)) j++;
            next[i] = j;
        }
        return next;
    }
}