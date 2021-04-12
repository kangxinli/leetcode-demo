package com.sample.app.c0002;

import com.sample.app.entity.ListNode;

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
	
	public static void main(String[] args) {
		int[] n1 = {9,9,9,9,9,9,9};
		ListNode l1 = ListNode.getNode(n1);
		
		
		int[] n2 = {9,9,9,9};
		ListNode l2 = ListNode.getNode(n2);
		
		ListNode result = addTwoNumbers(l1, l2);
		
		ListNode.print(result);
	}
	
}
