package MaxAndMinHeap;
import java.util.*;

public class MaxHeap {
    private List<Integer> heap;

    public MaxHeap(){
        // index 0 based
        this.heap = new ArrayList<>();
    }
    
    // push 
    public void push(int val){
        heap.add(val);
        int i = heap.size() - 1;

        while(i > 0 && heap.get( (i - 1) / 2) < heap.get(i)){
            swap((i - 1) / 2, i);
            i = (i - 1) / 2;
        }
    }
    // pop
    public int pop(){
        if(isEmpty()) throw new NoSuchElementException("empty heap");
        if(heap.size() == 1) return heap.remove(0);       
        int top = heap.get(0);
        int last = heap.remove(size() - 1);

        heap.set(0, last);
        int i = 0;
        
        while(true){
            int left = 2 * i + 1, right = 2 * i + 2, parent = i;  
            if(left < size() && heap.get(parent) < heap.get(left)) parent = left;
            if(right < size() && heap.get(parent) < heap.get(right)) parent = right;
            if(parent == i) break; 
            swap(parent, i);
            i = parent;
        }
        return top;

    }
    // maxheap heapify
    public void heapify(int[] arr){
        heap.clear();
        for(int num : arr) heap.add(num);
        int n = heap.size(); 
        // left: 2 * i + 1 >= n, don't have leaf
        for(int i = (n - 1) / 2; i >= 0; i--){
            siftdown(i, n);
        }
    }

    private void siftdown(int i, int n){
        while(true){
                int left = 2 * i + 1, right = 2 * i + 2, parent = i;
                if(left < n && heap.get(left) > heap.get(parent)) parent = left;
                if(right < n && heap.get(right) > heap.get(parent)) parent = right;
                if(parent == i) break;
                swap(parent, i);
                i = parent;
        }
    }

    // peek
    public int peek(){
        return heap.get(0);
    }   
    // isEmpty
    public boolean isEmpty(){
        return heap.isEmpty();
    }   
    // size 
    public int size(){
        return heap.size();
    }
    // swap 
    private void swap(int a, int b){
        int tempA = heap.get(a);
        int tempB =  heap.get(b);
        heap.set(b, tempA);
        heap.set(a, tempB);

    }
}
