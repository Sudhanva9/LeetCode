// BFS, WITHOUT SORTING

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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        // Base Case
        if (root == null) {
            return res;
        }

        // Map to track and group the nodes with the same column
        Map<Integer, ArrayList> columnTable = new HashMap<>();

        // For BFS and storing the node along with its corresponding column
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();

        int column = 0;
        queue.offer(new Pair(root, column)); // Root node is added to start BFS

        int minColumn = 0, maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            root = pair.getKey();
            column = pair.getValue();

            if (root != null) {
                if (!columnTable.containsKey(column)) {
                    columnTable.put(column, new ArrayList<Integer>());
                }
                columnTable.get(column).add(root.val);
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);

                queue.offer(new Pair(root.left, column - 1));
                queue.offer(new Pair(root.right, column + 1));
            }
        }
        
        for (int i = minColumn; i < maxColumn + 1; i++) {
            res.add(columnTable.get(i));
        }
        return res;
    }
}
