package algo_1309;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[100001];

        dp[0] = 0;
        dp[1] = 3;
        dp[2] = 7;

        int div = 9901;
        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901;

        System.out.println(dp[n]);
    }
}
