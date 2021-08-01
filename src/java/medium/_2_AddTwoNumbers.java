package medium;

import model.ListNode;

public class _2_AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        int i = 0;
        while(l1 != null || l2 != null){
            int sum = i;
            sum += (l1 != null ? l1.val : 0);
            sum += (l2 != null ? l2.val : 0);

            ListNode next;
            if(sum > 9){
                i = 1;
                next = new ListNode(sum - 10);
            }else{
                i = 0;
                next = new ListNode(sum);
            }

            curr.next = next;
            curr = curr.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(i > 0) {
            curr.next = new ListNode(i);
        }

        return head.next;
    }

    public static void main(String[] args) {
        _2_AddTwoNumbers.addTwoNumbers(new ListNode(8), new ListNode(7));
    }
}
