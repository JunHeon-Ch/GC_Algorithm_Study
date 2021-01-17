package algo_11722;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[1000];
        int[] dp = new int[1000];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (num[i] < num[i - j]) {
                    dp[i] = max(dp[i - j] + 1, dp[i]);
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();


    }
}
