package com.lin.util;

/**
 * @author liuxiaojia
 * @date 2022/10/26 19:09
 * @Description:
 */
public class LeetCode200岛屿问题 {

    public static void main(String[] args) {
        String[][] grid = new String[][]{
            {"1","1","1","1","0"},
            {"1","1","0","1","0"},
            {"1","1","0","0","0"},
            {"0","0","0","1","0"}
        };
        // 计算最大岛屿面积
//        int area = maxAreaOfIsland(grid);
//        System.out.println(area);
        // 岛屿数量
        int count = countOfIsLand(grid);
        System.out.println(count);
    }

    /**
     * 计算最大岛屿面积
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland(String[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if ("1".equals(grid[r][c])) {
                    int a = area(grid, r, c);
                    res = Math.max(res, a);
                }
            }
        }
        return res;
    }

    /**
     * 计算岛屿面积
     * @param grid
     * @param r
     * @param c
     * @return
     */
    public static int area(String[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return 0;
        }
        if (!"1".equals(grid[r][c])) {
            return 0;
        }
        grid[r][c] = "2";

        return 1
            + area(grid, r - 1, c)
            + area(grid, r + 1, c)
            + area(grid, r, c - 1)
            + area(grid, r, c + 1);
    }

    /**
     * 计算岛屿面积
     * @param grid
     * @param r
     * @param c
     * @return
     */
    public static void dfs(String[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return;
        }
        if (!"1".equals(grid[r][c])) {
            return;
        }
        grid[r][c] = "2";
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public static int countOfIsLand(String[][] grid){
        int res = 0;
        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                if ("1".equals(grid[r][c])){
                    res++;
                    dfs(grid, r, c);
                }
            }
        }
        return res;
    }

    public static boolean inArea(String[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
            && 0 <= c && c < grid[0].length;
    }
}
