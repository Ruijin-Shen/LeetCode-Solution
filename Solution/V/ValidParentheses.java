package Solution.V;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentheses {
}

class Solution20 {
    private static final Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            switch(ch){
                case '(':
                case '[':
                case '{':
                    stack.addLast(ch);
                    break;
                default:
                    if(stack.isEmpty() || map.get(ch) != stack.removeLast()) return false;
            }
        }
        return stack.isEmpty();
    }
}