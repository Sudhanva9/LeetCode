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
    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode current = head;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (current != null) {
            map.put(current.val, map.getOrDefault(current.val, 0) + 1);
            current = current.next;
        }

        for (Integer val : map.values()) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }

        return dummy.next;
    }
}
