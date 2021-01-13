package algo_10844;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] dp = new int[10][n];
        for (int i = 1; i < 10; i++) {
            dp[i][0] = 1;
        }
        int div = 1000000000;

        for (int i = 1; i < n; i++) {
            dp[0][i] = (dp[0][i] + dp[1][i - 1]) % div;
            dp[9][i] = (dp[9][i] + dp[8][i - 1]) % div;
            for (int j = 1; j < 9; j++) {
                dp[j][i] += (dp[j - 1][i - 1] + dp[j + 1][i - 1]) % div;
            }

        }

        long total = 0;
        for (int i = 0; i < 10; i++) {
            total += dp[i][n - 1];
        }
        System.out.println(total % div);
    }
}
