package 기초.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no15990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[100001][4];
        long ans;

        dp[1][1] = dp[2][2] = dp[3][3] = 1;
        for(int i=1; i<100001; i++){
            if(i>1) dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1000000009;
            if(i>2) dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1000000009;
            if(i>3) dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1000000009;
        }

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            ans = (dp[n][1] + dp[n][2] + dp[n][3]) % 1000000009;
            sb.append(ans);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
