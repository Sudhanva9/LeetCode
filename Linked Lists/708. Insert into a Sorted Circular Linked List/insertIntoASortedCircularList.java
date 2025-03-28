/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node insert = new Node(insertVal);

        if (head == null) {
            insert.next = insert;
            return insert;
        }

        Node cur = head;

        while (cur != null) {
            if (insertVal >= cur.val && insertVal <= cur.next.val) {
                break;
            }

            if (cur.val > cur.next.val && (insertVal >= cur.val || insertVal <= cur.next.val)) {
                break;
            }

            cur = cur.next;

            if (cur == head) break;
        }

        Node next = cur.next;
        cur.next = insert;
        insert.next = next;

        return head;
    }
}
