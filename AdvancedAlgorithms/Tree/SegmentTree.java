package Tree;

public class SegmentTree {

    int sum;
    SegmentTree left;
    SegmentTree right;
    int R;
    int L;

    public SegmentTree(int L, int R, int total){
        this.L = L;
        this.R = R;
        this.sum = total;
        this.left = null;
        this.right = null;
    }
    // O(N)
    public SegmentTree build(int[]nums, int L, int R){
        if(L == R){
            return new SegmentTree(L, R, nums[L]);
        }
        int M = L + (R - L) / 2;
        SegmentTree root = new SegmentTree(L, R, 0);
        root.left = build(nums, L, M);
        root.right = build(nums, M + 1, R);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    // O(logn) 
    public void update(int index, int val){
        // update base case
        if(this.L == this.R){
            this.sum = val;
            return;
        }

        int M = this.L + (this.R - this.L) / 2;

        if(index > M){
            this.right.update(index, val);
        }else{
            this.left.update(index, val);
        }
        this.sum = this.left.sum + this.right.sum;
    }

    // O(logn) 
    public int rangeQuery(int left, int right){
        // look for the range
        if(this.L == left && this.R == right) return this.sum;

        int M = this.L + (this.R - this.L) / 2;

        if(left > M){
            return this.right.rangeQuery(left, right);
        }else if(right <= M){
            return this.left.rangeQuery(left, right);
        }else{
            return this.left.rangeQuery(left, M) + this.right.rangeQuery(M + 1, right);
        }
    }

}
