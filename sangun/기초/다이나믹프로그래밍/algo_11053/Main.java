package algo_11053;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[1001];
        int[] dp = new int[1001];
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dp[0] = 1;

        // dpmax는 그 지점의 최고 길이
        int dpmax;
        for (int i = 0; i < n; i++) {
            dpmax = 0;
            for (int j = 0; j <= i; j++) {
                // 내 지점이 전들 지점보다 크면서
                // 지점의 최고 길이도 길거나 같다면
                // dpmax의 길이에 그 길이를 넣어주고 그 길이에 자신을 포함하기 위해 1을 더한다.
                if (arr[i] > arr[j] && dp[j] >= dpmax) {
                    dpmax = dp[j];
                    dp[i] = dp[j] + 1;
                }
                // 전체를 돌았는데도 못 찾았을때는 자기자신을 1로 둠
                if (dpmax == 0) {
                    dp[i] = 1;
                }
            }
        }

        int max = dp[0];
        for (int i = 0; i < n; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(max);


    }

}

