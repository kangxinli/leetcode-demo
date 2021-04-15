package com.sample.app.c0023;

import com.sample.app.entity.ListNode;

public class Solution2 {
	
	public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private static ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
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
