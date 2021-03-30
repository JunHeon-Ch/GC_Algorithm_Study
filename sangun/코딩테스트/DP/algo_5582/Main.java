package algo_5582;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        int size1 = arr1.length;
        int size2 = arr2.length;


        int[][] dp = new int[size1 + 1][size2 + 1];
        int ans = 0;
        for (int i = 1; i <= size1; i++) {
            for (int j = 1; j <= size2; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        System.out.println(ans);

    }
}
