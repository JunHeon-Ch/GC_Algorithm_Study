package algo_11066;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] num = new int[n];
            int[] sum = new int[n];
            int[][] dp = new int[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            sum[0] = num[0];
            for (int i = 1; i < n; i++) sum[i] += sum[i - 1] + num[i];

            for (int k = 1; k <= n; k++) {
                for (int i = 0; i + k < n; i++) {
                    int j = i + k;
                    dp[i][j] = Integer.MAX_VALUE;

                    for (int z = i; z < j; z++) {
                        if (i==0) dp[i][j] = Math.min(dp[i][z] + dp[z + 1][j] + sum[j], dp[i][j]);
                        else dp[i][j] = Math.min(dp[i][z] + dp[z + 1][j] + sum[j] - sum[i-1], dp[i][j]);
                    }
                }
            }
            bw.write(dp[0][n - 1] + "\n");

        }

        bw.close();
    }
}
