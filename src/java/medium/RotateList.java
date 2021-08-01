package medium;

import model.ListNode;

public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        int len = 1;
        ListNode tail = head;
        for (; tail.next != null; len++) {
            tail = tail.next;
        }

        if (k == len) {
            return head;
        }

        tail.next = head;

        int i = len - k % len;

        ListNode newTail = head;
        for (int j = 1; j < i; j++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
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

        rotateRight(head, 6);
    }
}
