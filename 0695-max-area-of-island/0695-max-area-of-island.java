class Solution {
    int max = 0;
    public int dfs(int grid[][], int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1)
            return 0;
        grid[i][j] = 0;
        int curr = 1;
        curr += dfs(grid, i + 1, j);
        curr += dfs(grid, i - 1, j);
        curr += dfs(grid, i, j + 1);
        curr += dfs(grid, i, j - 1);
        return curr;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }
}