package Solution.V;

public class ValidPalindrome {
}

class Solution125 {
    public boolean isPalindrome(String s) {
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
        }
        return true;
    }
}

class Solution125Stream {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        s.chars().filter(c -> Character.isLetterOrDigit(c)).mapToObj(c -> Character.toLowerCase((char) c)).forEach(builder::append);
        return builder.toString().equals(builder.reverse().toString());
    }
}