package com.sample.app.c0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * 回溯算法 + 剪枝
 *
 */
public class Solution {
	
	public static List<List<Integer>> combine(int[] nums, int k) {
		List<List<Integer>> res = new ArrayList<>();
		// 关键步骤
        Arrays.sort(nums);
		backtrack(0, nums, k, res, new ArrayList<Integer>());
		return res;
	}
	
	private static void backtrack(int index, int[] nums, int k, List<List<Integer>> res, List<Integer> tmp) {
		
		IntSummaryStatistics stats = tmp.stream().mapToInt((x) -> x).summaryStatistics();
		if (stats.getSum() == k) {
			res.add(new ArrayList<>(tmp));
			return;
		}
		
		for (int j = index; j < nums.length; j++) {
			// 剪枝
			if (k - stats.getSum() < nums[j]) {
				break;
			}
			if (j > index && nums[j] == nums[j - 1]) {
				continue;
			}
			tmp.add(nums[j]);
			backtrack(j + 1, nums, k, res, tmp);
			tmp.remove(tmp.size() - 1);
		}
		
	}

	public static void main(String[] args) {
		
		int[] nums = {10,1,2,7,6,1,5};
    	List<List<Integer>> result = combine(nums, 8);
    	
    	System.out.println(result.toString());
	}

}
