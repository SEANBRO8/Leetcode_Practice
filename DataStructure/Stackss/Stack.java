package Stackss;
import java.util.*;

public class Stack {
    public boolean matchUp(String s){
        Deque<Character> st = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if(st.isEmpty()) return false;
                char open = st.pop();
                if(open != c) return false;
            }
        }
        return st.isEmpty();
    }

    public Deque<Integer> monotonicAdd(int[] nums){
        Deque<Character> st = new ArrayDeque<>();

        while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
            st.pop(); // 越小的都被更大的"淘汰"
        }
        st.push(i);
        return st;
    }


    public Deque<Integer> monotonicMinus(int[] nums){
        Deque<Character> st = new ArrayDeque<>();
        
        while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
            st.pop(); // 越小的都被更大的"淘汰"
        }
        st.push(i);
        return st;
    }
}
