package Merge;
import java.util.*;

public class MergeSort {

    int[]temp;

    public static void main(String[]args){
        MergeSort sort = new MergeSort();
            List<Integer> arr = Arrays.asList(5, 2, 4, 6, 1, 3, 7, 0, -1, -5, 10, 100, 77);
            sort.mergeSortStart(arr);

            for (int n : arr) {
                System.out.print(n + " ");
        }
    }

    public void mergeSortStart(List<Integer> pairs){
        int left = 0, right = pairs.size() - 1;
        temp = new int[ pairs.size()];
        divide(left, right, pairs);
    }

    public void divide(int left, int right, List<Integer> pairs){
        if(left < right){
            int mid = left + (right - left) / 2;
            divide(left, mid, pairs);
            divide(mid + 1, right, pairs);
            merge(left, mid, right, pairs);
        }
    }

    public void merge(int left, int mid, int right, List<Integer> pairs){
        // copy sorted
        for(int i = left; i <= right; i++) temp[i] = pairs.get(i);

        int i = left, j = mid + 1;

        for(int p = left; p <= right; p++){
            // reach the board, copy the rest
            if(i == mid + 1){
                pairs.set(p,  temp[j]);
                j++;
            // reach the board, copy the rest
            }else if(j == right + 1){
                pairs.set(p,  temp[i]);
                i++;                
            }else if(temp[i] > temp[j]){
                // do comparison
                pairs.set(p,  temp[j]);
                j++;
            }else{
                pairs.set(p,  temp[i]);
                i++;
            }
        }
    }
}
