package MaxAndMinHeap;
import java.util.*;

public class MinHeap1 {
    private List<Integer> heap;

    public MinHeap1() {
        // 0-based index heap
        this.heap = new ArrayList<>();
    }

    // O(log n): Push element onto heap
    public void push(int val) {
        heap.add(val);
        int i = heap.size() - 1;
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(parent) <= heap.get(i))
                break;
            swap(i, parent);
            i = parent;
        }
    }

    // O(log n): Pop min element from heap
    public int pop() {
        if (isEmpty())
            throw new NoSuchElementException("empty heap");
        if (heap.size() == 1)
            return heap.remove(0);
        int top = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        heap.set(0, last);

        int i = 0;
        int size = heap.size();
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIndex = i;

            if (left < size && heap.get(left) < heap.get(minIndex))
                minIndex = left;
            if (right < size && heap.get(right) < heap.get(minIndex))
                minIndex = right;
            if (minIndex == i)
                break;
            swap(i, minIndex);
            i = minIndex;
        }
        return top;

    }

    // maxheap heapify
    public void heapify(int[] arr){
        heap.clear();
        for(int num : arr) heap.add(num);
        int n = heap.size(); 

        // left: 2 * i + 1 >= n, don't have leaf
        for(int i = n / 2 - 1; i >= 0; i--){
            siftdown(i, n);
        }
    }

    private void siftdown(int i, int n){
        while(true){
                int left = 2 * i + 1, right = 2 * i + 2, parent = i;
                if(left < n && heap.get(left) < heap.get(parent)) parent = left;
                if(right < n && heap.get(right) < heap.get(parent)) parent = right;
                if(parent == i) break;
                swap(parent, i);
                i = parent;
        }
    }


    // Peek at min element
    public int peek() {
        if (isEmpty())
            throw new NoSuchElementException("empty heap");
        return heap.get(0);
    }

    // Check if heap is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Get heap size
    public int size() {
        return heap.size();
    }

    // Swap two elements in the heap
    private void swap(int a, int b) {
        int temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }
}
