package com.sample.app.c0093;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 回溯算法
 *
 */
public class Solution {
	
	public static List<String> partition(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<String> stack = new ArrayDeque<>();
        dfs(s, 0, len, stack, res);
        return res;
    }
	
	private static void dfs(String s, int index, int len, Deque<String> path, List<String> res) {
        if (index == len && path.size() == 4) {
            res.add(String.join(".", path));
            return;
        }

        for (int i = index; i < len; i++) {
            // 因为截取字符串是消耗性能的，因此，采用传子串下标的方式判断一个子串是否是回文子串
            if (!judgeIpSegment(s, index, i)) {
                continue;
            }
            path.addLast(s.substring(index, i + 1));
            dfs(s, i + 1, len, path, res);
            path.removeLast();
        }
    }
	
	private static boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }
	
	public static void main(String[] args) {
		String s = "101023";
		List<String> result = partition(s);
    	
    	System.out.println(result.toString());
	}
}
