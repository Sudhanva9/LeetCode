/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode current = head;
        ListNode lastMNode = head;

        while (current != null) {
            int mCount = m;
            int nCount = n;

            while (current != null && mCount != 0) {
                lastMNode = current;
                current = current.next;
                mCount -= 1;
            }

            while (current != null && nCount != 0) {
                current = current.next;
                nCount -= 1; 
            }

            lastMNode.next = current;
        }
        return head;
    }
}
