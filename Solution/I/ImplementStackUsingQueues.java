package Solution.I;

import java.util.*;

public class ImplementStackUsingQueues {
}

class MyStack225 {
    private Queue<Integer> queue;

    public MyStack225() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        for(int i = 0; i < size - 1; i++){
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}