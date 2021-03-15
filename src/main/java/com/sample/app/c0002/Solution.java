package com.sample.app.c0002;

/**
 * 
 * 两数相加 
 *
 */
public class Solution {
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;
            
            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        return root.next;
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
		int[] n1 = {9,9,9,9,9,9,9};
		ListNode l1 = getNode(n1);
		
		
		int[] n2 = {9,9,9,9};
		ListNode l2 = getNode(n2);
		
		ListNode result = addTwoNumbers(l1, l2);
		
		print(result);
	}
	
	public static void print(ListNode node) {
		while(node != null) {
			System.out.print(node.val);
			node = node.next;
		}
	}

}
