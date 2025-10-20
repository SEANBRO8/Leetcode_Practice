package Insertion;
public class Insertion {
    public static void main(String[] args){
            Insertion sort = new Insertion();
            int[] arr = {5, 2, 4, 6, 1, 3};
            sort.insertionSort(arr);

            for (int n : arr) {
                System.out.print(n + " ");
            }
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

    private void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
