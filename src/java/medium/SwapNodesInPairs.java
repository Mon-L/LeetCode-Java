package medium;

import model.ListNode;

public class SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1), cursor = dummy;
        dummy.next = head;

        while (cursor.next != null && cursor.next.next != null) {
            ListNode start = cursor.next;
            ListNode end = cursor.next.next;

            start.next = end.next;
            end.next = start;
            cursor.next = end;
            cursor = start;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);  //n1 prev
        ListNode n1 = new ListNode(2);   // n2
        ListNode n2 = new ListNode(3);   //
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(swapPairs(head));

        // 1 -> 2 -> 3 -> 4
        // 2 -> 1 -> 3 ->4
    }
}
