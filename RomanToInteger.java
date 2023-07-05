import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
}

class Solution13 {
    private static final Map<Character, Integer> numbers = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public int romanToInt(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            int value = numbers.get(s.charAt(i));
            if(i < s.length() - 1 && value < numbers.get(s.charAt(i + 1))){
                result -= value;
            }else{
                result += value;
            }
        }
        return result;
    }
}