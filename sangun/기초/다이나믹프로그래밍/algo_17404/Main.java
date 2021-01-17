package algo_17404;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] num = new int[1001][3];
        int[][] dp = new int[1001][3];
        int result = 1000000;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                if (i == k) dp[1][i] = num[1][i];
                else dp[1][i] = 1000000;
            }

            for (int i = 2; i <= n; i++) {
                dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + num[i][0];
                dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + num[i][1];
                dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + num[i][2];
            }

            for (int i = 0; i < 3; i++)
                if (i != k) result = min(result, dp[n][i]);
        }


        bw.write(result + "\n");
        bw.flush();
        bw.close();

    }
}
