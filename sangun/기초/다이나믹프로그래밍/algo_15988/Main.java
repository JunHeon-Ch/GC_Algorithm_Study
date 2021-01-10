package algo_15988;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
            if (num[i] > max) {
                max = num[i];
            }
        }

        long[] dp = new long[1000001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int div = 1000000009;

        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 1] % div + dp[i - 2] % div + dp[i - 3] % div;
        }
        for (int i : num) {
            bw.write(dp[i]%div + "\n");
        }

        bw.flush();
        bw.close();

    }
}
