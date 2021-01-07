package algo_1463;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[1000001];
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i < n + 1; i++) {
            if (i % 3 == 0 && dp[i / 3] < dp[i - 1]) {
                dp[i] = 1 + dp[i / 3];
            } else if (i % 2 == 0 && dp[i / 2] < dp[i - 1]) {
                dp[i] = 1 + dp[i / 2];
            } else {
                dp[i] = 1 + dp[i - 1];
            }
        }

        System.out.println(dp[n]);

    }
}
