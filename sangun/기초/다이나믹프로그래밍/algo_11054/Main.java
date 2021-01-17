package algo_11054;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[1000];
        int[] dp1 = new int[1000];
        int[] dp2 = new int[1000];
        int[] dp = new int[1000];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dp1[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (num[i] > num[i - j]) {
                    dp1[i] = max(dp1[i - j] + 1, dp1[i]);
                }
            }

        }

        for (int i = n - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = n - 1; j >= i; j--) {
                if (num[i] > num[j]) {
                    dp2[i] = max(dp2[j] + 1, dp2[i]);
                }
            }

        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = dp1[i] + dp2[i] - 1;
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();


    }
}
