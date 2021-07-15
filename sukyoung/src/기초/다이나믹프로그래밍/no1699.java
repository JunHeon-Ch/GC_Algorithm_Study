package 기초.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];

        for(int i=1; i<=n; i++){
            dp[i] = i;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j*j<=i; j++){
                if(dp[i] > dp[i - (j*j)] + 1)
                    dp[i] = dp[i - (j*j)] + 1;
            }
        }
        System.out.println(dp[n]);
    }
}
