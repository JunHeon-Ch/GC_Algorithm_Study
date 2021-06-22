package algo_5557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        long[][] dp = new long[n][20+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][num[0]] = 1;
        for (int i = 1; i < n-1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] != 0) {
                    if (j - num[i] >= 0) {
                        dp[i][j - num[i]] += dp[i - 1][j];
                    }
                    if (j + num[i] <= 20) {
                        dp[i][j + num[i]] += dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(dp[n-2][num[n-1]]);

    }
}
