package algo_1495;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] v = new int[n + 1];

        v[0] = s;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int[] k : dp) {
            Arrays.fill(k, -1);
        }
        dp[0][s] = s;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i - 1][j] == -1) continue;

                int max = dp[i - 1][j] + v[i];
                int min = dp[i - 1][j] - v[i];

                if (max <= m) dp[i][max] = max;
                if (min >= 0) dp[i][min] = min;

            }
        }
        Arrays.sort(dp[n]);
        System.out.println(dp[n][m]);

    }
}
