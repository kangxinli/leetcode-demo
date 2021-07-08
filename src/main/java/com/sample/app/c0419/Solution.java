package com.sample.app.c0419;

public class Solution {

	/**
	 * 动规五部曲分析如下：
		1. 确定dp数组以及下标的含义
			01背包中，dp[i] 表示： 容量为j的背包，所背的物品价值可以最⼤为dp[j]。
			套到本题，dp[i]表示 背包总容量是i，最⼤可以凑成i的⼦集总和为dp[i]。
		2. 确定递推公式
			01背包的递推公式为：dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
			本题，相当于背包⾥放⼊数值，那么物品i的重量是nums[i]，其价值也是nums[i]。
			所以递推公式：dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]);
		3. dp数组如何初始化
			在01背包，⼀维dp如何初始化，已经讲过，
			从dp[j]的定义来看，首先dp[0]⼀定是0。
			如果如果题目给的价值都是正整数那么非0下标都初始化为0就可以了，如果题⽬给的价值有负数，那么
			非0下标就要初始化为负⽆穷。
			这样才能让dp数组在递归公式的过程中取的最⼤的价值，而不是被初始值覆盖了。
			本题题⽬中 只包含正整数的非空数组，所以非0下标的元素初始化为0就可以了。
		4. 确定遍历顺序
			在动态规划：关于01背包问题，你该了解这些！（滚动数组）中就已经说明：如果使⽤⼀维dp数组，物
			品遍历的for循环放在外层，遍历背包的for循环放在内层，且内层for循环倒叙遍历！
			// 题⽬中说：每个数组中的元素不会超过 100，数组的大小不会超过 200
			// 总和不会⼤于20000，背包最大只需要其中⼀半，所以10001大小就可以了
		5. 举例推导dp数组
			dp[i]的数值⼀定是⼩于等于i的。
			如果dp[i] == i 说明，集合中的⼦集总和正好可以凑成总和i，理解这⼀点很重要。
	 * @param nums
	 * @return
	 */
    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        // 题目已经说非空数组，可以不做非空判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        int[] dp = new int[10001];

        // 开始 01背包
        for (int i = 0; i < len; i++) {
        	// 每⼀个元素⼀定是不可重复放入，所以从大到小遍历
            for (int j = target; j >= nums[i]; j--) {
            	dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        // 集合中的元素正好可以凑成总和target
        if (dp[target] == target) return true;
        return false;
    }
    
    public static void main(String[] args) {
		int[] nums = {1, 5, 5, 11};
		System.out.println(canPartition(nums));
	}
}
