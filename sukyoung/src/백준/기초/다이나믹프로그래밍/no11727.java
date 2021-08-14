package 기초.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no11727 {
    public static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n+1];
        dp[0] = dp[1] = 1;
        if(n>=2){
            for(int i=2; i<=n; i++){
                dp[i] = (dp[i-1] + 2*dp[i-2]) % 10007;
            }
        }
        System.out.println(dp[n]);
    }
}
