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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                int dupVal = curr.val;
                ListNode tmp = curr;
                while (tmp != null && tmp.val == dupVal) tmp = tmp.next;

                if (prev == null) {
                    head = tmp;
                } else {
                    prev.next = tmp;
                }
                curr = tmp;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}