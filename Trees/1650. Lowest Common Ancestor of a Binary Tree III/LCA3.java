/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node p_copy = p;
        Node q_copy = q;

        while (p_copy != q_copy) {
            if (p_copy != null) {
                p_copy = p_copy.parent;
            } else {
                p_copy = q;
            }
            if (q_copy != null) {
                q_copy = q_copy.parent;
            } else {
                q_copy = p;
            }
            
        }

        return p_copy;
    }
}
