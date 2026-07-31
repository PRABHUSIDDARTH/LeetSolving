class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int left, int right) {

        // Only one list
        if (left == right)
            return lists[left];

        int mid = left + (right - left) / 2;

        ListNode l1 = divide(lists, left, mid);
        ListNode l2 = divide(lists, mid + 1, right);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode a, ListNode b) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (a != null && b != null) {

            if (a.val <= b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }

            curr = curr.next;
        }

        if (a != null)
            curr.next = a;
        else
            curr.next = b;

        return dummy.next;
    }
}