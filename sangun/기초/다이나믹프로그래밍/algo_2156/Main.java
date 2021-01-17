package algo_2156;

import java.io.*;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[10001];
        int[] num = new int[10001];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = num[0];
        dp[1] = num[0] + num[1];
        dp[2] = num[2] + max(num[1], num[0]);
        dp[3] = num[3] + max(dp[1], dp[0] + num[2]);

        for (int i = 4; i < n; i++) {
            dp[i] = num[i] + max(max(dp[i - 2], dp[i - 3] + num[i - 1]), dp[i - 4] + num[i - 1]);
        }
        if (n == 1) {
            bw.write(num[0] + "\n");
        } else {
            bw.write(max(dp[n - 2], dp[n - 1]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
