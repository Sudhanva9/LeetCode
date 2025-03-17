// Method 1: targetSum - node value

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}

// Method 2: targetSum == curSum

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

      private boolean dfs(TreeNode node, int curSum, int targetSum) {
            if (node == null) {
                return false;
            }

            curSum += node.val;

            if (node.left == null && node.right == null) {
                return curSum == targetSum;
            } 

            return (dfs(node.left, curSum, targetSum) ||
                    dfs(node.right, curSum, targetSum));

        }
}
