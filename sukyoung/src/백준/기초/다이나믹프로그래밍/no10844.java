package 기초.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no10844 {
    static Long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Long[n+1][10]; // 0부터 9까지 n+1자리일 때 계단 수 저장
        //첫번째 자리수는 1로 초기화
        for(int i=0; i<10; i++)
            dp[1][i] = 1L;

        long ans = 0;
        for(int i=1; i<10; i++)
            ans += DP(n,i);

        System.out.println(ans % 1000000000);
    }
    public static long DP(int digit, int val){
        if(digit == 1)
            return dp[digit][val];

        if(dp[digit][val] == null){
            if(val == 0)
                dp[digit][val] = DP(digit -1, 1);
            else if(val == 9)
                dp[digit][val] = DP(digit -1, 8);
            else
                dp[digit][val] = DP(digit -1, val -1) + DP(digit -1, val+1);
        }
        return dp[digit][val] % 1000000000;
    }
}
