package com.lin.util.test;

/**
 * @author liuxiaojia
 * @date 2023/1/30 09:56
 * @Description:
 */
public class LeetCode979在二叉树中分配硬币 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0, new TreeNode(3), new TreeNode(0));
        int result = distributeCoins(root);
        System.out.println(result);
    }

    static int ans;

    public static int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = dfs(node.left);
        int R = dfs(node.right);
        ans += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;
    }


    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
