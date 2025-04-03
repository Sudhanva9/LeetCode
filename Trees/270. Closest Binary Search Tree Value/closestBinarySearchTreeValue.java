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
    public int closestValue(TreeNode root, double target) {
        double closestDist = Integer.MAX_VALUE;
        int res = 0;

        while (root != null) {
            double distance = Math.abs(root.val - target);
            if (distance < closestDist ||
                (distance == closestDist && root.val < res)) {
                    closestDist = distance;
                    res = root.val;
            }

            if (distance == 0) return root.val;

            if (root.val < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return res;
    }
}
