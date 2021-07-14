package 기초.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2193 {
    public static Long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Long[n+1][10];

        for(int i=0; i<10; i++)
            dp[1][i] = 1L;

        Long ans = 0L;
        ans = DP(n, 1);
        System.out.println(ans);

    }
    public static Long DP(int digit, int val){
        if(digit == 1)
            return dp[digit][val];

        if(dp[digit][val] == null){
            if(val == 1)
                dp[digit][val] = DP(digit-1, 0);
            else
                dp[digit][val] = DP(digit-1, 1) + DP(digit-1, 0);
        }
        return dp[digit][val];
    }
}
