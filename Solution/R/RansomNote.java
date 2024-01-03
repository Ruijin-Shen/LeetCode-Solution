package Solution.R;

public class RansomNote {
}

class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        for(char ch : magazine.toCharArray()){
            count[ch - 'a']++;
        }
        for(char ch : ransomNote.toCharArray()){
            count[ch - 'a']--;
        }

        for(int i : count){
            if(i < 0) return false;
        }
        return true;
    }
}