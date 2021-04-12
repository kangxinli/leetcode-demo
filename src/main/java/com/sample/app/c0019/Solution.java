package com.sample.app.c0019;

import com.sample.app.entity.ListNode;

public class Solution {

	// 递归解法
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		return removeNode(head, n) == n ? head.next : head;
	}

	public static int removeNode(ListNode node, int n) {
		if (node.next == null)
			return 1;
		int m = removeNode(node.next, n);
		if (m == n)
			if (m == 1)
				node.next = null;
			else
				node.next = node.next.next;
		return m + 1;
	}

	public static void main(String[] args) {
		int[] n1 = {1, 2};
		ListNode l1 = ListNode.getNode(n1);

		ListNode result = removeNthFromEnd(l1, 1);
		
		ListNode.print(result);
	}
	
}
