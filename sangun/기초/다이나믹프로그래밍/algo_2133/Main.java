package algo_2133;

import java.util.Scanner;

public class Main {
    static int[] dp = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(tile(n));
    }

    public static int tile(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 3;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int result = 3 * tile(n - 2);
        for (int i = 4; i <= n; i += 2) {
            result += 2 * tile(n - i);
        }
        return dp[n] = result;
    }
}

