package com.sample.app.entity;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
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
	
	public static void print(ListNode node) {
		while(node != null) {
			System.out.print(node.val);
			node = node.next;
		}
	}

}
