package algo_9251;

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

        for (int i = 0; i < size1 + 1; i++) {
            for (int j = 0; j < size2 + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        for (int i = 0; i < size1 + 1; i++) {
            for (int j = 0; j < size2 + 1; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        StringBuilder sb = new StringBuilder();
        int i = size1;
        int j = size2;
        while (i != 0 && j != 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else {
                sb.append(arr1[i - 1]);
                i--;
                j--;
            }
        }


        System.out.println(dp[size1][size2]);
        System.out.println(sb.reverse().toString());

    }
}
