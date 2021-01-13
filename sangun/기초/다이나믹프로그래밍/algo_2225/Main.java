package algo_2225;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] dp = new int[k + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[1][i] = 1;
        }

        int div = 1000000000;

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= j; l++) {
                    dp[i][j] =(dp[i][j]+ dp[i - 1][j - l])%div;
                }
            }
        }

        System.out.println(dp[k][n]%div);
    }
}
