package Solution.E;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        int j = 0;
    }
}

class Solution150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for(String token : tokens){
            if(isNumber(token)){
                stack.addFirst(Integer.parseInt(token));
                continue;
            }

            int op2 = stack.removeFirst(), op1 = stack.removeFirst();
            switch(token){
                case "+": stack.addFirst(op1 + op2); break;
                case "-": stack.addFirst(op1 - op2); break;
                case "*": stack.addFirst(op1 * op2); break;
                case "/": stack.addFirst(op1 / op2); break;
                default:
            }
        }

        return stack.removeFirst();
    }

    public boolean isNumber(String token){
        return !(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }
}
