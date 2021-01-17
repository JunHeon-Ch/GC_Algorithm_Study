package algo_11057;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[][] dp = new long[1001][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i]++;
        }
        int div = 10007;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % div;
                }
            }
        }
        int total = 0;
        for (int i = 0; i < 10; i++) {
            total += dp[n][i];
        }
        System.out.println(total % 10007);


    }
}
