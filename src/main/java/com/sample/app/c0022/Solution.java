package com.sample.app.c0022;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	static List<String> res = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    // 深度优先搜索算法
    private static void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")");
        }
    }
    
    public static void main(String[] args) {
		System.out.println(generateParenthesis(4));
	}

}
