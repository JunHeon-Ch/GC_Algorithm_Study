package 기초.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no15988 {
    public static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());

            for(int j=4; j<=n; j++)
                dp[j] = (dp[j-1] + dp[j-2] + dp[j-3]) % 1000000009;

            sb.append(dp[n]);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
