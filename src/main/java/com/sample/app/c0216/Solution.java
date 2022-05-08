package com.sample.app.c0216;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Solution {
	
	public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, 1, res, new ArrayList<>());
        return res;
    }

    private static void backtrack(int n, int k, int index, List<List<Integer>> res, List<Integer> tmp) {
        
        IntSummaryStatistics stats = tmp.stream().mapToInt((x) -> x).summaryStatistics();
		if (stats.getSum() == k && tmp.size() == n) {
			res.add(new ArrayList<>(tmp));
			return;
		}

		for (int j = index; j < 10; j++) {
			// 剪枝
			if (k - stats.getSum() < j) {
				break;
			}
			tmp.add(j);
			backtrack(n, k, j + 1, res, tmp);
			tmp.remove(tmp.size() - 1);
		}
    }

	public static void main(String[] args) {
		List<List<Integer>> result = combine(3, 9);
    	
    	System.out.println(result.toString());
	}

}
