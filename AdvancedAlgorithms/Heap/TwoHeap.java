package Heap;
import java.util.*;

public class TwoHeap {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public TwoHeap(){
        // maxHeap
        small = new PriorityQueue<>(Collections.reverseOrder());
        // minHeap
        large = new PriorityQueue<>();
    }

    public void insect(int num){
        small.add(num);

        int val; 

        if(!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()){
            val = small.poll();
            large.add(val);
        }
        // uneven size
        if (small.size() > large.size() + 1) {
            val = small.poll();
            large.add(val);
        }

        if (large.size() > small.size() + 1) {
            val = large.poll();
            small.add(val);
        }
    }

    public double getMedian() {
        if (small.size() > large.size()) {
            return (double) (small.peek());
        } else if (large.size() > small.size()) {
            return (double) large.peek();
        }

        // Even # of elements, return avg of two middle nums
        return (double) (small.peek() + large.peek()) / 2;
    }

}
