package com.sample.app.c0003;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
给定一个只有小写字母组成的字符串，统计每个字母出现次数，并按字母出现频率从高到低输出（出现频率相同，按字典顺序）

例如 给定 abbbbc
输出
b4a1c1 
 *
 */
public class Demo {
	
	public static void test(String in) {
		Map<Character, Integer> map = new HashMap<>();
		
		char[] chars = in.toCharArray();
		
		for (int i = 0; i < chars.length; i++) {
			if (map.containsKey(chars[i])) {
				Integer num = map.get(chars[i]);
				num += 1;
				map.put(chars[i], num);
			} else {
				map.put(chars[i], 1);
			}
		}
		
		ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>();
		list.addAll(map.entrySet());
		
		ValueComparator vc = new ValueComparator();
		
		Collections.sort(list, vc);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getKey() + "" + list.get(i).getValue());
		}
 	}
	
	public static void main(String[] args) {
		String str = "abbbbc";
		test(str);
	}
}

class ValueComparator implements Comparator<Map.Entry<Character, Integer>> {

	@Override
	public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
		int i = o2.getValue() - o1.getValue();
		if (i == 0) {
			return o1.getKey() - o2.getKey();
		} else {
			return i;
		}
		
	}
	
}
