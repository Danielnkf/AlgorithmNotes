/*
 * Given a binary tree, determine if it is height-balanced.

 * For this problem, a height-balanced binary tree is defined as a binary tree in which 
 * the depth of the two subtrees of every node never differ by more than 1. 
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Be careful of meaning of balancedtree is that each node in tree is balanced
public class BalancedBinaryTree {
    public int depth(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 
            && isBalanced(root.left) && isBalanced(root.right);
    }

/*****************************************************************************/

    public boolean isBalanced(TreeNode root) {
        return balancedHelper(root) >= 0;
    }

    public int balancedHelper(TreeNode root) {
        if(root == null)
            return 0;
        int leftDepth = balancedHelper(root.left);
        int rightDepth = balancedHelper(root.right);
        if(leftDepth < 0 || rightDepth < 0 || Math.abs(leftDepth - rightDepth) > 1)
            return -1;
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
