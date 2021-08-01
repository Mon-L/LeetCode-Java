package medium;

import model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _143_ReorderList {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i++).next = list.get(j);
            if (i == j) {
                break;
            }
            list.get(j--).next = list.get(i);
        }
        list.get(i).next = null;
    }

    public void reorderList2(ListNode head) {
        if (head == null || head.next == null) return;

        //找到中间节点
        ListNode mid = findMiddleNode(head);

        //断开中间节点
        ListNode head2 = mid.next;
        mid.next = null;

        //反转head2
        head2 = reverseList(head2);

        //合并两个链表
        mergeList(head, head2);
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void mergeList(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;

            l1.next = l2;
            l2.next = next1;

            l1 = next1;
            l2 = next2;
        }
    }
}
