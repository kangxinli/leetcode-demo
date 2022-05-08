package com.sample.app.c0078;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法
 *
 */
public class Solution {
	
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(0, nums, res, new ArrayList<Integer>());
		return res;
	}
	
	private static void backtrack(int i, int[] nums, List<List<Integer>> res, List<Integer> tmp) {
		
		res.add(new ArrayList<>(tmp));
		for (int j = i; j < nums.length; j++) {
			tmp.add(nums[j]);
			backtrack(j + 1, nums, res, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
    	List<List<Integer>> result = subsets(nums);
    	
    	System.out.println(result.toString());
	}
}
