package algo_2193;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // long[][] dp = new long[n+1][2];
        // 다음과 같이 동적으로 받는 것 보다 밑 코드가 훨씬 빠르다.
        long[][] dp = new long[91][2];

        dp[0][1] = 1;
        dp[1][0] = 1;

        for (int i = 2; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        System.out.println(dp[n - 1][0] + dp[n - 1][1]);

    }
}
