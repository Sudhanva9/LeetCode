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
    public String gameResult(ListNode head) {

        if (head == null) return "Tie";

        int evenPoints = 0;
        int oddPoints = 0;

        ListNode even = head;
        ListNode odd = head.next;

        while (even != null && even.next != null) {
            if (odd != null && even.val > odd.val) {
                evenPoints += 1;
            } else {
                oddPoints += 1;
            }

            even = even.next.next;
            if (odd.next != null) odd = odd.next.next;
        }

        if (evenPoints > oddPoints) {
            return "Even";
        } else if (oddPoints > evenPoints) {
            return "Odd";
        }

        return "Tie";
    }
}
