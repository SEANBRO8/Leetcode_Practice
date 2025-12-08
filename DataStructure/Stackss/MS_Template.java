package Stackss;
import java.util.*;
public class MS_Template {
    public static void main(String[] args){
        Deque<Character> st = new ArrayDeque<>();
        int n = 0;
        int[]nums = new int[n];
        // ===== 单调递增栈（找更小） =====
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            st.push(i);
        }

        // ===== 单调递减栈（找更大） =====
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            st.push(i);
        }
        /**
         * 
         *  // ===== 左右边界找法（以“找更小”为例）=====
            for (i: 0→n-1):
                while (栈顶 >= 当前) pop
                left[i] = 栈顶 or -1
                push
         * 
         * 
         * 
         */
        

        
        /** // 清空栈
         *  for (i: n-1→0):
            while (栈顶 > 当前) pop
            right[i] = 栈顶 or n
            push

         */
        /**
         * 
         *  
         * // ===== Greedy 单调栈（字典序最小）=====
            for x in chars:
                while (peek > x && 可以弹) pop
                push x
         * 
         * 
         * 
         */
        
     
    }
    }
     
