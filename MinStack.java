import java.util.*;

class MinStack {
    Deque<int[]> stack;

    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        if(stack.size() == 0) stack.addLast(new int[]{val, val});
        else stack.addLast(new int[]{val, Math.min(val, stack.getLast()[1])});
    }

    public void pop() {
        stack.removeLast();
    }

    public int top() {
        return stack.getLast()[0];
    }

    public int getMin() {
        return stack.getLast()[1];
    }
}