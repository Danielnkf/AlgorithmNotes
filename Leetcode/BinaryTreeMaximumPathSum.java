/*
 * Given a binary tree, find the maximum path sum.

 * The path may start and end at any node in the tree.

 * For example:
 * Given the below binary tree,

 *       1
 *      / \
 *     2   3
 * Return 6.
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
/*
	 P
       /  \
      L    R
MaxPathSum = max(P,P+L,P+R,P+L+R)
Return Value pf helper = Max(P,P+L,P+R)
Java dont have reference,so use Array or global variable
*/
public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        helper(root,max);
        return max[0];
    }
    public int helper(TreeNode p,int[] max){
        if(p==null) return 0;
        int L = helper(p.left,max);
        int R = helper(p.right,max);
        int sub = p.val + Math.max(Math.max(Math.max(0,L),R),L+R);
        if(sub>max[0])
            max[0] = sub;
        return Math.max(p.val,Math.max(p.val+L,p.val+R));
    }
}

import java.util.ArrayList;

public class BinaryTreeMaximumPathSum {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return res;
    }

    public int maxSum(TreeNode root) {
        if(root == null)
            return 0;
        int L = maxSum(root.left);
        int R = maxSum(root.right);
        int subMax = root.val + Math.max(Math.max(0, Math.max(L, R)), L + R);
        if(res < subMax)
            res = subMax;
        return root.val + Math.max(0, Math.max(L, R));
    }

/*****************************************************************************/

	/public int maxPathSum(TreeNode root) {
		//pass the curmax in an array that contains only one value
		ArrayList<Integer> curMax = new ArrayList<Integer>(1);
		curMax.add(Integer.MIN_VALUE);
		maxSubPath(root, curMax);
		return curMax.get(0);
	}
	
	private int maxSubPath(TreeNode root, ArrayList<Integer> curMax) {
		if(root == null)
			return 0;
		int leftMax = Math.max(0, maxSubPath(root.left, curMax));
		int rightMax = Math.max(0, maxSubPath(root.right, curMax));
		curMax.set(0, Math.max(curMax.get(0), root.val + leftMax + rightMax));
		return Math.max(root.val + leftMax, root.val + rightMax);
	}
}
