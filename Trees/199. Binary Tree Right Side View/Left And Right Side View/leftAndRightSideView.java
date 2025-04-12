class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> leftSide = new ArrayList<>();
        List<Integer> rightSide = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (i == 0) leftSide.add(node.val);
                if (i == size - 1) rightSide.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = leftSide.size() - 1; i >= 0; i--) {
            result.add(leftSide.get(i));
        }
        for (int i = 1; i < rightSide.size(); i++) {
            result.add(rightSide.get(i));
        }

        return result;
    }
}
