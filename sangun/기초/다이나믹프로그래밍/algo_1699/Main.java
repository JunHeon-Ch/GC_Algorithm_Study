package algo_1699;

import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[1000001];

        for (int i = 1; i <= n; i++)
        {
            dp[i] = i; // 먼저 가장 최악의 경우인 1^2로 구성되는 방법
            for (int j = 1; j <= sqrt(i); j++)
            {
                dp[i] = min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[n]);



    }
}
