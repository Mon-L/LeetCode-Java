package medium;

import model.ListNode;

public class _92_ReverseBetween {

    /**
     * 1 -> 2 -> 3 -> 4 -> 5   , l = 2, r = 4
     * pre -> cur  next -> 4
     * 1 -> 3 -> 2 -> 4 -> 5
     * 1 -> 4 -> 3 -> 2 -> 5
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println(new _92_ReverseBetween().reverseBetween(head, 2, 4));
    }
}
