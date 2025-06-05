/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
};
*/

class Solution {
    public int[] toArray(Node head) {
        if (head == null) return null;

        Node current = head;
        int count = 0;

        while (current != null) {
            count += 1;
            current = current.next;
        }

        int[] res = new int[count];
        int start = 0;
        current = head;

        while (current != null && start != count) {
            res[start] = current.val;
            current = current.next;
            start += 1;
        }
        return res;
    }
}
