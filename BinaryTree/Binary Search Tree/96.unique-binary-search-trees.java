/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    // dp
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    public int count(int start, int end){
        if(start > end) return 1;
        if(memo[start][end] != 0) return memo[start][end];
        int ans = 0;
        for(int i = start; i <= end; i++){
            int left = count(start, i - 1);
            int right = count(i + 1, end);
            ans += left * right;
        }
        memo[start][end] = ans;
        return ans;
    }
}
// @lc code=end

