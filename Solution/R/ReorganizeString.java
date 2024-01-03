package Solution.R;

public class ReorganizeString {
}

class Solution767 {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        int n = s.length();
        for(char ch : s.toCharArray()){
            count[ch - 'a']++;
        }

        int maxCount = 0, maxChar = 0;
        for(int i = 0; i < 26; i++){
            if(count[i] > maxCount){
                maxCount = count[i];
                maxChar = i;
            }
        }

        if(maxCount > n + 1 >> 1) return "";

        char[] result = new char[n];
        int index = 0;
        while(maxCount > 0){
            result[index] = (char)(maxChar + 'a');
            index += 2;
            maxCount--;
        }
        count[maxChar] = 0;

        for(int i = 0; i < 26; i++){
            for(int j = 0; j < count[i]; j++){
                if(index >= n) index = 1;
                result[index] = (char)(i + 'a');
                index += 2;
            }
        }

        return String.valueOf(result);
    }
}