package algo_11058;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] dp = new long[101];

        for (int i = 0; i < 7; i++) {
            dp[i] = i;
        }

        for (int i = 7; i <= 100; i++) {
            for (int j = 1; j <= i - 3; j++) {
                dp[i] = Math.max(Math.max(dp[i - (j + 2)] * (j + 1), dp[i - 1] + 1), dp[i]);
            }
        }

        System.out.println(dp[n]);

    }
}
