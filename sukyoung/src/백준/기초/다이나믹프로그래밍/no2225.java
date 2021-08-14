package 기초.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2225 {
    public static int n;
    public static int k;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n+1][k+1];

        for(int i=1; i<=n; i++)
            dp[i][1] = 1;
        for(int i=1; i<=k; i++)
            dp[1][i] = i;

        for(int i=2; i<=n; i++)
            for(int j=2; j<=k; j++)
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;

        System.out.println(dp[n][k]);
    }

}
