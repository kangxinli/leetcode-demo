package com.sample.app.c0001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 两数之和
 *
 */
public class Solution {
	
	public static int[] method1(int[] nums, int target) {
		int l = nums.length;
		int[] ans = new int[2];
		int i, j;
		for (i = 0; i < l - 1; i++) {
			for (j = i + 1; j < l; j++) {
				if (nums[i] + nums[j] == target) {
					ans[0] = i;
					ans[1] = j;
				}
			}
		}
		return ans;
	}
	
	public static int[] method2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length - 1; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[]{map.get(target - nums[i]), i};
			} else {
				map.put(nums[i], i);
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		
		long startTime = System.currentTimeMillis();
//		int[] result = method1(nums, target);
		int[] result = method2(nums, target);
		long endTime = System.currentTimeMillis();
		System.out.println(Arrays.toString(result));
		System.out.println("耗时 ： " + (endTime - startTime));
	}

}
