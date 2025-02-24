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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        while (lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2) {
                ListNode L1 = lists[i];
                ListNode L2 = (i + 1) < lists.length ? lists[i + 1] : null;
                mergedLists.add(mergeList(L1, L2));  
            }
            lists = mergedLists.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    private ListNode mergeList (ListNode L1, ListNode L2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (L1 != null && L2 != null) {
            if (L1.val < L2.val) {
                node.next = L1;
                L1 = L1.next;
            }
            else {
                node.next = L2;
                L2 = L2.next;
            }
            node = node.next;
        }

        if (L1 != null) {
            node.next = L1;
        }
        else {
            node.next = L2;
        }
        return dummy.next;
    }

}
