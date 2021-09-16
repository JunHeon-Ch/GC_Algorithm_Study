package 푼문제;

import java.util.Arrays;

public class 정수삼각형 {
    static int[][] dp;

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        dp = new int[triangle.length][triangle[triangle.length - 1].length];
        System.out.println(dp(triangle,0, 0));

    }

    static int dp(int[][] triangle, int depth, int index) {
        if (depth >= triangle.length) {
            return 0;
        }
        if (dp[depth][index] != 0) {
            return dp[depth][index];
        }
        return dp[depth][index] = triangle[depth][index] + Math.max(dp(triangle, depth + 1, index), dp(triangle, depth + 1, index + 1));
    }


}
