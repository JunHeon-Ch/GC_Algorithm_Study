package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기2 {
    static int n;
    static int[][] map;
    static long[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[n + 1][n + 1][3];
        dp[1][2][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 3; j < n + 1; j++) {
                if (map[i][j] == 1) continue;
                // 가로
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                // 세로
                dp[i][j][1] = dp[i - 1][j][2] + dp[i - 1][j][1];
                // 대각선
                if (map[i - 1][j] != 1 && map[i][j - 1] != 1) {
                    dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }


        System.out.println(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]);
    }


}
