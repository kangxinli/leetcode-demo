package com.sample.app.c0144;

import java.util.Stack;

import com.sample.app.entity.TreeNode;

/**
 * 二叉树的遍历（迭代）
 * 主要有三种：
 * （1）先(根)序遍历（根左右）
 * （2）中(根)序遍历（左根右）
 * （3）后(根)序遍历（左右根）
 *
 */
public class Solution2 {
	
	/**
	 * 前序遍历
	 * @param head
	 */
	public static void preOrderIteration(TreeNode head) {
		if (head == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(head);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.print(node.val + " ");
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}
	
	/**
	 * 中序遍历
	 * @param head
	 */
	public static void inOrderIteration(TreeNode head) {
		if (head == null) {
			return;
		}
		TreeNode cur = head;
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || cur != null) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			TreeNode node = stack.pop();
			System.out.print(node.val + " ");
			if (node.right != null) {
				cur = node.right;
			}
		}
	}
	
	/**
	 * 后序遍历
	 * @param head
	 */
	public static void postOrderIteration(TreeNode head) {
		if (head == null) {
			return;
		}
		TreeNode cur = head;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(head);
		while (!stack.isEmpty()) {
			TreeNode peek = stack.peek();
			if (peek.left != null && peek.left != cur && peek.right != cur) {
				stack.push(peek.left);
			} else if (peek.right != null && peek.right != cur) {
				stack.push(peek.right);
			} else {
				System.out.print(stack.pop().val + " ");
				cur = peek;
			}
		}
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
		preOrderIteration(root);
		System.out.println();
		
		System.out.print("中序遍历：");
		inOrderIteration(root);
		System.out.println();
		
		System.out.print("后序遍历：");
		postOrderIteration(root);
	}

}
