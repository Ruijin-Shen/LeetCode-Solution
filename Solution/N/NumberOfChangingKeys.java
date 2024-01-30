package Solution.N;

public class NumberOfChangingKeys {
}

class Solution3019 {
    public int countKeyChanges(String s) {
        String str = s.toLowerCase();
        char prev = ' ';
        int result = 0;
        for(char ch : str.toCharArray()){
            if(ch != prev){
                result++;
                prev = ch;
            }
        }
        return result - 1;
    }
}