package com.sample.app.c0017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解题算法：回溯算法
 *
 */
public class Solution {
	
	private static final Map<Character, char[]> mapping = new HashMap<>();

    static {
        mapping.put('2', new char[]{'a', 'b', 'c'});
        mapping.put('3', new char[]{'d', 'e', 'f'});
        mapping.put('4', new char[]{'g', 'h', 'i'});
        mapping.put('5', new char[]{'j', 'k', 'l'});
        mapping.put('6', new char[]{'m', 'n', 'o'});
        mapping.put('7', new char[]{'p', 'q', 'r', 's'});
        mapping.put('8', new char[]{'t', 'u', 'v'});
        mapping.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        dfs(digits, 0, result, "");
        return result;
    }

    private static void dfs(String digits, int index, List<String> result, String str) {
        if (digits.length() == index) {
            result.add(str);
            return;
        }
        final char digit = digits.charAt(index);
        final char[] letters = mapping.get(digit);
        for (char letter : letters) {
            dfs(digits, index + 1, result, str + letter);
        }
    }

	public static void main(String[] args) {
		System.out.println(letterCombinations("34"));
	}

}
