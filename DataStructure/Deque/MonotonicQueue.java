package Deque;
import java.util.*;

public class MonotonicQueue {
    Deque<Integer> dq = new ArrayDeque<>();

    void push(int x) {
        while (!dq.isEmpty() && dq.peekLast() < x) {
            dq.pollLast();
        }
        dq.offerLast(x);
    }

    void pop(int x) {
        if (!dq.isEmpty() && dq.peekFirst() == x) {
            dq.pollFirst();
        }
    }

    int max() {
        return dq.peekFirst();
    }

}
