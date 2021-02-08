package algo_17425;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        long[] num = new long[1000001];
        Arrays.fill(num, 1);
        for (int i = 2; i <= 1000000; i++) {
            for (int j = 1; i * j <= 1000000; j++) {
                num[i * j] += i;
            }
        }
        long[] dp = new long[1000001];
        for (int i = 1; i <= 1000000; i++) {
            dp[i] = dp[i - 1] + num[i];
        }
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }
        bw.close();
    }
}

