package com.sample.app.c0046;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public class Solution {
	
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		
		boolean[] used = new boolean[nums.length];
		backtrack(nums, used, res, new ArrayList<Integer>());
		return res;
	}
	
	private static void backtrack(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> tmp) {
		
		if (tmp.size() == nums.length) {
			res.add(new ArrayList<>(tmp));
			return;
		}
		
		for (int j = 0; j < nums.length; j++) {
			if (used[j] == true) {
				continue;
			}
			tmp.add(nums[j]);
			used[j] = true;
			backtrack(nums, used, res, tmp);
			// 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
			used[j] = false;
			tmp.remove(tmp.size() - 1);
		}
		
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3};
    	List<List<Integer>> result = permute(nums);
    	
    	System.out.println(result.toString());
	}

}
