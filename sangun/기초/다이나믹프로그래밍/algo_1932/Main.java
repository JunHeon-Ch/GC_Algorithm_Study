package algo_1932;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[501][501];
        int[][] num = new int[501][501];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            dp[i][1] = dp[i - 1][1] + num[i][1];
            dp[i][i] = dp[i - 1][i - 1] + num[i][i];
            for (int j = 2; j < i; j++) {
                dp[i][j] = max(dp[i - 1][j-1], dp[i - 1][j]) + num[i][j];
            }
        }
        long result = 0;

        for (int i = 1; i <= n; i++) {
            if (result < dp[n][i]) {
                result = dp[n][i];
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();

    }
}
