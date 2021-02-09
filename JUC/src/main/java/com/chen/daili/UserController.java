package com.chen.daili;

/**
 * Description :   .
 *
 * @author : chenyuxiang
 * @date : Created in 2021/2/8 11:37 上午
 */
public class UserController {

}

class Solution {
	public static int[][] transpose(int[][] A) {
		int R = A.length, C = A[0].length;
		int[][] ans = new int[C][R];
		for (int r = 0; r < R; ++r) {
			for (int c = 0; c < C; ++c) {
				ans[c][r] = A[r][c];
			}
		}
		return ans;
	}
	public static void main(String[] args) {

	}
}
