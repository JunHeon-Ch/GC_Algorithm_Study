package algo_9465;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int[][] dp = new int[2][100001];


        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] num = new int[2][n + 1];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    num[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = num[0][1];
            dp[1][1] = num[1][1];

            for (int j = 2; j <= n; j++) {
                dp[0][j] = max(dp[1][j - 1], dp[1][j - 2]) + num[0][j];
                dp[1][j] = max(dp[0][j - 2], dp[0][j - 1]) + num[1][j];
            }
            bw.write(max(dp[0][n], dp[1][n]) + "\n");
        }

        bw.flush();
        bw.close();
    }

}
