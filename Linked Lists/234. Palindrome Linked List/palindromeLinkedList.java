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

// STACK

class Solution {
    public boolean isPalindrome(ListNode head) {

        if (head == null) return true;
        Stack<Integer> stack = new Stack<>();

        ListNode current = head;
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        current = head;

        while (current != null) {
            if (stack.pop() != current.val) return false;
            current = current.next;
        }
        return true;
    }
}

// TWO POINTERS

class Solution {
    public boolean isPalindrome(ListNode head) {

        if (head == null) return true;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = slow;
        ListNode current = slow.next;
        slow.next = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        slow = head;
        
        while (prev != null) {
            if (slow.val != prev.val) {
                return false;
            } 
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }
}
