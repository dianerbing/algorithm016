package wb.test;

/**
 * 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumIslands {
    //递归搜索
    public void land(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length
                || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = 'x';
        land(grid, i, j + 1);
        land(grid, i, j - 1);
        land(grid, i + 1, j);
        land(grid, i - 1, j);
    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        int x = grid.length;
        if (x < 1) return 0;
        int y = grid[0].length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == '1') {
                    ans ++;
                    land(grid, i, j);
                }
            }
        }

        return ans;
    }
}
