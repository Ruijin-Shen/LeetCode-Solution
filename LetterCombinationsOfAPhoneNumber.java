import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
}

class Solution17DFS {
    private static final Map<Character, char[]> map = Map.of(
            '2', "abc".toCharArray(),
            '3', "def".toCharArray(),
            '4', "ghi".toCharArray(),
            '5', "jkl".toCharArray(),
            '6', "mno".toCharArray(),
            '7', "pqrs".toCharArray(),
            '8', "tuv".toCharArray(),
            '9', "wxyz".toCharArray());

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if(digits.length() == 0) return result;

        helper(digits, 0, new StringBuilder(), result);
        return result;
    }

    private static void helper(String digits, int index, StringBuilder builder, List<String> result){
        if(index == digits.length()){
            result.add(builder.toString());
            return;
        }

        for(char ch : map.get(digits.charAt(index))){
            builder.append(ch);
            helper(digits, index + 1, builder, result);
            builder.deleteCharAt(index);
        }
    }
}
