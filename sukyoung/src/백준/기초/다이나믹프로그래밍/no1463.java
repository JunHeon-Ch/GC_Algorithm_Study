package 기초.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no1463 {
    public static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        dp = new Integer[x+1];
        dp[0] = dp[1] = 0;

        System.out.println(makeOne(x));
    }
    public static int makeOne(int N){
        if(dp[N] == null){
            if(N % 6 == 0)
                dp[N] = Math.min(makeOne(N - 1), Math.min(makeOne(N / 3), makeOne(N / 2))) + 1;
            else if(N % 3 == 0)
                dp[N] = Math.min(makeOne(N/3), makeOne(N - 1)) + 1;
            else if(N % 2 == 0)
                dp[N] = Math.min(makeOne(N/2), makeOne(N - 1)) + 1;
            else
                dp[N] = makeOne(N - 1) + 1;
        }
        return dp[N];
    }
}
