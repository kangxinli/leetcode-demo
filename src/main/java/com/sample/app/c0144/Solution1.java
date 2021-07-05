package com.sample.app.c0144;

import com.sample.app.entity.TreeNode;

/**
 * 二叉树的遍历（递归）
 * 主要有三种：
 * （1）先(根)序遍历（根左右）
 * （2）中(根)序遍历（左根右）
 * （3）后(根)序遍历（左右根）
 *
 */
public class Solution1 {
	
	
	/**
	 * 前序遍历
	 * @param head
	 */
	public static void preOrderRecur(TreeNode head) {
	    if (head == null) {
	        return;
	    }
	    System.out.print(head.val + " ");
	    preOrderRecur(head.left);
	    preOrderRecur(head.right);
	}
	
	/**
	 * 中序遍历
	 * @param head
	 */
	public static void inOrderRecur(TreeNode head) {
	    if (head == null) {
	        return;
	    }
	    inOrderRecur(head.left);
	    System.out.print(head.val + " ");
	    inOrderRecur(head.right);
	}
	
	/**
	 * 后序遍历
	 * @param head
	 */
	public static void postOrderRecur(TreeNode head) {
	    if (head == null) {
	        return;
	    }
	    postOrderRecur(head.left);
	    postOrderRecur(head.right);
	    System.out.print(head.val + " ");
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		TreeNode left1 = new TreeNode(2);
		TreeNode right1 = new TreeNode(3);
		
		TreeNode left2 = new TreeNode(4);
		TreeNode right2 = new TreeNode(5);
		
		root.left = left1;
		root.right = right1;
		
		left1.left = left2;
		left1.right = right2;
		
		System.out.print("前序遍历：");
		preOrderRecur(root);
		System.out.println();
		
		System.out.print("中序遍历：");
		inOrderRecur(root);
		System.out.println();
		
		System.out.print("后序遍历：");
		postOrderRecur(root);
	}

	
}

