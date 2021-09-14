package 푼문제;

public class 보행자천국 {

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] cityMap = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        int[][][] dp = new int[m + 1][n + 1][2];
        dp[1][1][1] = dp[1][1][0] = 1;

        for (int x = 1; x <= m; x++) {
            for (int y = 1; y <= n; y++) {
                if (cityMap[x - 1][y - 1] == 0) {
                    dp[x][y][0] += dp[x - 1][y][0] + dp[x][y - 1][1];
                    dp[x][y][1] += dp[x - 1][y][0] + dp[x][y - 1][1];
                } else if (cityMap[x - 1][y - 1] == 1) {
                    dp[x][y][0] = 0;
                    dp[x][y][1] = 0;
                } else {
                    dp[x][y][0] = dp[x - 1][y][0];
                    dp[x][y][1] = dp[x][y - 1][1];
                }
            }
        }


        System.out.println(dp[m][n][0]);
        System.out.println(dp[m][n][1]);
    }


}
