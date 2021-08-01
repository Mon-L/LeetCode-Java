package easy;

import model.ListNode;

public class _203_RemoveElements {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        head.next = removeElements(head.next, val);

        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = n1.next = new ListNode(2);
        ListNode n3 = n2.next = new ListNode(6);
        ListNode n4 = n3.next = new ListNode(3);
        ListNode n5 = n4.next = new ListNode(4);
        ListNode n6 = n5.next = new ListNode(5);
        ListNode n7 = n6.next = new ListNode(6);

        System.out.println(_203_RemoveElements.removeElements(n1, 6));
    }
}
