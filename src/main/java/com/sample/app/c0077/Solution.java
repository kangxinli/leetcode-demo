package com.sample.app.c0077;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 回溯算法 + 剪枝
 *
 */
public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int index, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 只有这里 i <= n - (k - path.size()) + 1 与参考代码 1 不同
        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            System.out.println("递归之前 => " + path);
            dfs(n, k, i + 1, path, res);
            System.out.println("递归之后 => " + path);
            path.removeLast();
        }
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	List<List<Integer>> result = solution.combine(4, 3);
    	
    	System.out.println(result.toString());
	}
}
