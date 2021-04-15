package com.sample.app.c0023;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.sample.app.entity.ListNode;

/**
 * 优先级队列
 * 时间复杂度:$O(n*log(k))$,n是所有链表中元素的总和,k是链表个数.
 *
 */
public class Solution1 {
	
	public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }
        return dummy.next;
    }
	
	public static void main(String[] args) {
		int[] n1 = {1, 2, 4, 5};
		ListNode l1 = ListNode.getNode(n1);
		
		int[] n2 = {3, 5, 6};
		ListNode l2 = ListNode.getNode(n2);
		
		ListNode[] list = {l1, l2};

		ListNode result = mergeKLists(list);
		ListNode.print(result);
	}

}
