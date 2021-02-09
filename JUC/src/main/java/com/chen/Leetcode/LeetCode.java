package com.chen.Leetcode;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * Description :   .
 *
 * @author : chenyuxiang
 * @date : Created in 2021/1/26 4:00 下午
 */
public class LeetCode {

	class Solution {

		public int maxSubArray(int[] nums) {
			int count = 0;
			int result = Integer.MIN_VALUE;
			for (int i = 0; i < nums.length; i++) { // 设置起始位置
				count = 0;
				for (int j = i; j < nums.length; j++) { // 每次从起始位置i开始遍历寻找最大值
					count += nums[j];
					result = count > result ? count : result;
				}
			}
			return result;
		}
	}

	@Test
	public void test1() {

	}

}
