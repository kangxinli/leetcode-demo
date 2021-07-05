package com.sample.app.c0070;

public class Solution {
	
	public static int climbStairs(int n) {
		int[] dp = new int[n + 1];
	    dp[0] = 1;
	    dp[1] = 1;
	    for (int i = 2; i <= n; i++) {
	        dp[i] = dp[i - 1] + dp[i - 2];
	    }
	    return dp[n];
	}
	
	/**
	 * 拓展
		这道题目还可以继续深化，就是⼀步⼀个台阶，两个台阶，三个台阶，直到 m个台阶，有多少种方法爬到n阶楼顶。
		这又有难度了，这其实是⼀个完全背包问题。
	 * @param n
	 * @return
	 */
	public static int climbStairs2(int n) {
		int m = 2;
		int[] dp = new int[n + 1];
	    dp[0] = 1;
	    for (int i = 1; i <= n; i++) {
	    	for (int j = 1; j <= m; j++) {
	    		if (i - j >= 0) {
	    			dp[i] += dp[i - j];
	    			System.out.println("i:" + i + "\t j:" + j + "\t dp[" + i + "]" + dp[i]);
	    		}
	    	}
	    }
	    return dp[n];
	}

    
    public static void main(String[] args) {
    	System.out.println(climbStairs(6));
    	System.out.println(climbStairs2(6));
	}
}
