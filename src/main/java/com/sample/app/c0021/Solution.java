package com.sample.app.c0021;

import com.sample.app.entity.ListNode;

public class Solution {
	
	// 递归
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = l1.val < l2.val ? l1 : l2;
        res.next = mergeTwoLists(res.next, l1.val >= l2.val ? l1 : l2);
        return res;
    }
	
	public static void main(String[] args) {
		int[] n1 = {1, 2, 4, 5};
		ListNode l1 = ListNode.getNode(n1);
		
		int[] n2 = {3, 5, 6};
		ListNode l2 = ListNode.getNode(n2);

		ListNode result = mergeTwoLists(l1, l2);
		ListNode.print(result);
	}
}
