package com.sample.app.c0019;

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

	public static ListNode getNode(int[] nums) {
		ListNode root = new ListNode(nums[0]);
		ListNode cursor = root;
		for (int i = 1; i <= nums.length - 1; i++) {
			ListNode numNode = new ListNode(nums[i]);
			cursor.next = numNode;
			cursor = numNode;
		}
		return root;
	}

	public static void main(String[] args) {
		int[] n1 = {1, 2};
		ListNode l1 = getNode(n1);

		ListNode result = removeNthFromEnd(l1, 1);
		
		print(result);
	}
	
	public static void print(ListNode node) {
		while(node != null) {
			System.out.print(node.val);
			node = node.next;
		}
	}

}
