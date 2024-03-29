/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
 * such that adding up all the values along the path equals the given sum.

 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null)
            return root.val == sum;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return recpath(root,0,sum);
    }
    public boolean recpath(TreeNode p,int sum,int tar){
        if(p==null) return false;
        sum+=p.val;
        if(p.left==null && p.right==null) {
            if(sum==tar) return true;
            else return false;
        }
        return recpath(p.left,sum,tar)||recpath(p.right,sum,tar) ;
    }
}
