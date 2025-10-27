package Arrays;
import java.util.ArrayList;
import java.util.List;

public class PrefixSum {
    List<Integer> prefix;

    public PrefixSum(int[] nums) {
        prefix = new ArrayList<>();
        int total = 0;
        for (int n : nums) {
            total += n;
            prefix.add(total);
        }
    }

    public int rangeSum(int left, int right) {
        /**
         *      L    R
         *   2 -1 3 -3 4
         *   2  1 4  1 5
         *          
         *           1
         *   
         */
        int preRight = prefix.get(right);
        int preLeft = left > 0 ? prefix.get(left - 1) : 0;
        return (preRight - preLeft);      
    }
}
