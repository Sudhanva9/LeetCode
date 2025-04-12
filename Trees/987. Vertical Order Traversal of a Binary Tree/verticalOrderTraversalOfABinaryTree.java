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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        // Map: column -> List of Pair<row, value>
        Map<Integer, List<Pair<Integer, Integer>>> columnTable = new HashMap<>();
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> queue = new LinkedList<>();

        queue.offer(new Pair<>(root, new Pair<>(0, 0)));

        int minColumn = 0, maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Pair<Integer, Integer>> curr = queue.poll();
            TreeNode node = curr.getKey();
            int col = curr.getValue().getKey();
            int row = curr.getValue().getValue();

            columnTable.putIfAbsent(col, new ArrayList<>());
            columnTable.get(col).add(new Pair<>(row, node.val));

            minColumn = Math.min(minColumn, col);
            maxColumn = Math.max(maxColumn, col);

            if (node.left != null) {
                queue.offer(new Pair<>(node.left, new Pair<>(col - 1, row + 1)));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, new Pair<>(col + 1, row + 1)));
            }
        }

        // Now sort and build result
        for (int col = minColumn; col <= maxColumn; col++) {
            List<Pair<Integer, Integer>> nodeList = columnTable.get(col);
            // Sort by row first, then value
            Collections.sort(nodeList, (a, b) -> {
                if (!a.getKey().equals(b.getKey())) {
                    return a.getKey() - b.getKey(); // sort by row
                } else {
                    return a.getValue() - b.getValue(); // then by value
                }
            });

            List<Integer> colList = new ArrayList<>();
            for (Pair<Integer, Integer> p : nodeList) {
                colList.add(p.getValue());
            }

            res.add(colList);
        }

        return res;
    }
}
