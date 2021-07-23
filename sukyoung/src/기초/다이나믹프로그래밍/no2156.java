package 기초.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2156 {
    public static int n;
    public static int[] wine;
    public static int[] dp;
    public static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        wine = new int[n+1];
        for(int i=1; i<=n; i++)
            wine[i] = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        dp[1] = wine[1];
        if(n>1)
            dp[2] = wine[1] + wine[2];

        for(int i=3; i<=n; i++)
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]));

        System.out.println(dp[n]);
    }

}
