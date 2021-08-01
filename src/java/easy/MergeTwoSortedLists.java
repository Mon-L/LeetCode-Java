package easy;

import model.ListNode;

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(3);
        ListNode n13 = new ListNode(5);
        ListNode n14 = new ListNode(8);

        n11.next = n12;
        n12.next = n13;
        n13.next = n14;

        ListNode n21 = new ListNode(2);
        ListNode n22 = new ListNode(3);
        ListNode n23 = new ListNode(5);
        ListNode n24 = new ListNode(10);

        n21.next = n22;
        n22.next = n23;
        n23.next = n24;

        ListNode head =  mergeTwoLists2(n11, n22);
        System.out.println(head);
    }

}
