package Solution.M;

public class MaximizeTheConfusionOfAnExam {
}

class Solution2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int result = 0;

        int Tcount = 0, Fcount = 0;
        for(int i = 0, j = 0; j < n; j++){
            if(answerKey.charAt(j) == 'T') Tcount++;
            else Fcount++;
            while(Tcount > k && Fcount > k){
                if(answerKey.charAt(i++) == 'T') Tcount--;
                else Fcount--;
            }
            result = Math.max(result, j - i + 1);
        }
        return result;
    }
}