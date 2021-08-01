package medium;

import model.ListNode;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 */
public class _328_OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);

        ListNode node = root;
        node = node.next = new ListNode(2);
        node = node.next = new ListNode(3);
        node = node.next = new ListNode(4);

        new _328_OddEvenList().oddEvenList(root);
    }
}
