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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode Left = dummy;
        ListNode Right = head;

        while (n > 0 && Right != null) {
            Right = Right.next;
            n -= 1;
        }

        while (Right != null) {
            Left = Left.next; 
            Right = Right.next;
        }

        Left.next = Left.next.next;
        return dummy.next;
    }
}
