public class LengthOfLastWord {
}

class Solution58 {
    public int lengthOfLastWord(String s) {
        char[] arr = s.toCharArray();
        int right = s.length() - 1;
        while(right >= 0 && arr[right] == ' ') right --;
        int result = 0;
        while(right >= 0 && arr[right] != ' '){
            right--;
            result++;
        }
        return result;
    }
}