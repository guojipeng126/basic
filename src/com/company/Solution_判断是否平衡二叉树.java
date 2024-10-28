package com.company;

import java.time.Instant;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：
 * 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 **/
public class Solution_判断是否平衡二叉树 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right)
                && Math.abs(heightTree(root.left) - heightTree(root.right)) <= 1) {
            return true;
        }
        return false;
    }

    //求左右子树高度 分别传入左子树、右子树
    public int heightTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(heightTree(root.left), heightTree(root.right)) + 1;
    }

}

class TreeNode{
    TreeNode left;
    TreeNode right;
}
