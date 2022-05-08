package com.sample.app.c0090;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法
 *
 */
public class Solution {
	
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		backtrack(0, nums, used, res, new ArrayList<Integer>());
		return res;
	}
	
	private static void backtrack(int i, int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> tmp) {
		
		res.add(new ArrayList<>(tmp));
		for (int j = i; j < nums.length; j++) {
			if (j > 0 && nums[j] == nums[j - 1] && used[j - 1] == false) {
				continue;
			}
			if (used[j] == false) {
				tmp.add(nums[j]);
				used[j] = true;
				backtrack(j + 1, nums, used, res, tmp);
				
				used[j] = false;
				tmp.remove(tmp.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 2};
    	List<List<Integer>> result = subsets(nums);
    	
    	System.out.println(result.toString());
	}
}
