package Counting;

public class CountingSort {
    public static void main(String[] args){
            // Insertion sort = new Insertion();
            int[] arr = {0, 1, 3, 2, 1, 4, 0, 5, 2, -1};
            // sort.insertionSort(arr);
            countingSort(arr);
            for (int n : arr) {
                System.out.print(n + " ");
            }
    }

    public static void countingSort(int[]arr){
        if( arr == null || arr.length <= 1) return;

        

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : arr){
            if(min > num) min = num;
            if(max < num) max = num;
        }
        // in case the offset,consider index Zero
        int range = max - min + 1;
        int[] counts = new int[range];
        for(int num : arr) counts[num - min]++;

        // get prefix, then we can know the position for the num
        for(int i = 1; i <= counts.length - 1; i++){
            counts[i] += counts[i - 1];
        }
        /**
         * 
         * 
         *  N -1  0   1   2   3   4   5
         *  C  1  2   2   2   1   1   1
         *  P  1  3   5   7   8   9  10    
         * Len = 10
         * Range = 7
         * 
         */
        int[] copy = new int [arr.length];
        for(int i = arr.length - 1; i >= 0; i--){
            int num = arr[i];
            int pos = counts[num - min] - 1;
            copy[pos] = num;
            counts[num - min]--;
        }

        for(int i= 0 ; i < copy.length; i++){
            arr[i] = copy[i];
        }
    }
}
