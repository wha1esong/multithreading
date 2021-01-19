package com.chen.Leetcode;

import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public int maximalSquare(char[][] matrix) {


        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        int maxSize = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSize;
        }
        int rows = matrix.length;
        int colnms = matrix[0].length;
        int dp[][] = new int[rows][colnms];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colnms; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }
        return maxSize * maxSize;
    }
}



