/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int diameter(Node root) {
        if (root == null || root.children.size() == 0) {
            return 0;
        }

        int[] maxDiameter = new int[1];
        dfs(root, maxDiameter);
        return maxDiameter[0];
    }

    private int dfs(Node root, int[] maxDiameter) {
        if (root.children.size() == 0) {
            return 0;
        }

        int maxHeight1 = -1;
        int maxHeight2 = -1;

        for (Node child : root.children) {
            int childHeight = dfs(child, maxDiameter);

            if (childHeight > maxHeight1) {
                maxHeight2 = maxHeight1;
                maxHeight1 = childHeight;
            } else if (childHeight > maxHeight2) {
                maxHeight2 = childHeight;
            }
        }

        maxDiameter[0] = Math.max(maxDiameter[0], maxHeight1 + maxHeight2 + 2);
        return maxHeight1 + 1;
    }
}
