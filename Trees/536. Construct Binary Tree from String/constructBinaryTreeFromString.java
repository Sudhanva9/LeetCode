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
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode parent = null;
        TreeNode curNode = null;
        int sign = 1;
        int c = 0; 

        while (c < s.length()) {
            if (s.charAt(c) == ')') {
                curNode = stack.pop();
                parent = stack.peek();
                if (parent.left != null) parent.right = curNode;
                else parent.left = curNode;
                c++;
            } else if (s.charAt(c) == '-') {
                sign = -1;
                c++;
            } else if (s.charAt(c) == '(') {
                c++;
            } else {
                int num = 0;
                while (c < s.length() && s.charAt(c) >= '0' && s.charAt(c) <= '9') {
                    num = num * 10 + s.charAt(c) - '0';
                    c++;
                }
                num *= sign;
                sign = 1;
                stack.push(new TreeNode(num));
            }
        }

        if (!stack.isEmpty()) {
            return stack.peek();
        }

        return parent;

    }
}
