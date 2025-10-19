package DataStructure.ArrayList;

public class DynamicArray {
    int[] list;
    int capacity;
    int size;
    
    public DynamicArray(int capacity) {
        this.size = 0;
        this.list = new int[capacity];
        this.capacity = capacity;
    }

    public int get(int i) {
        return this.list[i];
    }

    public void set(int i, int n) {
       this.list[i] = n;
    }

    public void pushback(int n) {
        if(this.size == this.capacity) this.resize();
        list[size] = n;
        size++;
    }

    public int popback() {
        if(size > 0) size--;
        return list[size];
    }

    private void resize() {
        this.capacity *= 2;
        int[] newList = new int[this.capacity];
        int index= 0;
        for(int num : list){
            newList[index++] = num;
        }
        list = newList;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
