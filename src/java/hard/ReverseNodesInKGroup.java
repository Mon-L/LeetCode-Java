package hard;

import model.ListNode;

public class ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count-- > 0) {
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;
    }

    public static ListNode reverseKGroup2(ListNode head, int k) {
        if (k == 1 || head== null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = head;
        while (true) {
            int count = 0;
            while (count < k && end != null) {
                end = end.next;
                count++;
            }

            if (count < k) {
                break;
            }

            ListNode curr = pre.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode next = curr.next;
                curr.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = curr;
            end = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(7);
        ListNode n7 = new ListNode(8);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        reverseKGroup2(head, 2);
    }

}
