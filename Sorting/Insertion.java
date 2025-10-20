package Sorting;

public class Insertion {
    
    public static void main(String[] args){

    }

    public void insertionSort(int[] arr){

        if(arr == null || arr.length == 0) return;
        for(int i = 1; i < arr.length; i++){
            int last = i - 1;
            while(last >= 0 && arr[last] > arr[last + 1]){
                swap(last, last + 1, arr);
                last--;
            }
        }
    }

    public void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
