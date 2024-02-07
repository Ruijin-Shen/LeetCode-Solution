package Solution.M;

public class MinimumTimeToRevertWordToInitialStateI {
}

class Solution3029 {
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

    public int minimumTimeToInitialState(String word, int k) {
        getNext(word);
        int n = word.length();
        for(int j = next[n - 1]; j > 0; j = next[j - 1]){
            if((n - j) % k == 0) return (n - j) / k;
        }
        return n / k + (n % k == 0 ? 0 : 1);
    }
}