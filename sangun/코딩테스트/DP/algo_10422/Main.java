package algo_10422;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int[] num = new int[t];

        int max = 0;
        for (int i = 0; i < t; i++) {
            num[i] = Integer.parseInt(br.readLine());
            if (max < num[i]) max = num[i];
        }

        long[] dp = new long[max + 1];

        int div = 1000000007;
        dp[0] = 1;
        dp[2] = 1;

        for (int i = 4; i <= max; i+=2) {
            long sum = 0;
            for (int j = 2; j <= i; j+=2) {
                sum = sum + (dp[j - 2] * dp[i - j]) % div;
            }
            dp[i] = sum % div;
        }

        for (int i = 0; i < t; i++) {
            bw.write(dp[num[i]] + "\n");
        }
        bw.close();
    }
}
