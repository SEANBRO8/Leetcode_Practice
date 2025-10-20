package Bucket;
import java.util.*;

public class BucketSort {
    public static void main(String[] args){
        double[] arr = new double[]{5.0, -2.0, 4.0, 6.0, 1.0, 3.0, 7.0, 0.0, -1.0, -5.0, 10.0, 100.0, 77.0};
        bucketSort(arr, 13);

        for (double n : arr) {
            System.out.print(n + " ");
        }
    }

    public static void bucketSort(double[] arr, int n){
        if (arr == null || arr.length <= 1 || n <= 0) return;

        double max = Double.MIN_VALUE, min = Double.MAX_VALUE;
        for(double num : arr){
            if(min > num) min = num;
            if(max < num) max = num;
        }

        double range = max - min;
        if(range == 0) return;


        List<List<Double>> bucket = new ArrayList<>();
        for(int i = 0; i < n; i++){
            bucket.add(new ArrayList<>());
        }

        for(double num : arr){
            int index = (int) ((num - min) / range * (n - 1));
            bucket.get(index).add(num);
            
        }

        for(List<Double> list : bucket){
            insertionSort(list);
            // Collections.sort(list);
        }

        int index = 0;
         for(List<Double> list : bucket){
            for(double num : list){
                arr[index++] = num;
            }
        }
  
    }

    public static void insertionSort(List<Double> arr){

        for(int i = 1; i < arr.size(); i++){
            int j = i - 1;
            while(j >= 0 && arr.get(j) > arr.get(j + 1)){
                swap(j+1, j, arr);
                j--;
            }
        }

    }

    private static void swap(int i, int j, List<Double> arr){
        double temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
