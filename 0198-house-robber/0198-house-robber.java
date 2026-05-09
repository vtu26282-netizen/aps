class Solution {
    Integer[] memo;

    public int rob(int[] nums) {
        memo = new Integer[nums.length];

        // Start 2 recursive calls from 0 and 1 indices.
        return Math.max(dfs(nums, 0), dfs(nums, 1));
    }

    private int dfs(int[] nums, int i) {
        if (i >= nums.length) return 0;
        if (memo[i] != null) return memo[i];

        memo[i] = nums[i] + Math.max(dfs(nums, i + 2), dfs(nums, i + 3));
        return memo[i];
    }
}