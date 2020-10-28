package wb.test;

public class MinPathSum {
    /**
     * 64. 最小路径和
     * https://leetcode-cn.com/problems/minimum-path-sum/
     */
    //解法：DP
    public int minPathSum_1(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) return 0;
        dp(grid, 0);
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public void dp(int[][] grid, int row) {
        if (row >= grid.length) return;

        for (int i = 0; i < grid[0].length; i++) {
            if (row == 0 && i == 0) continue;
            else if (row == 0) grid[row][i] += grid[0][i - 1];
            else if (i == 0) grid[row][i] += grid[row - 1][0];
            else grid[row][i] += Math.min(grid[row - 1][i], grid[row][i - 1]);
        }

        dp(grid, row + 1);
    }
}
