package algo_10942;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            if (num[i] == num[i + 1]) dp[i][i + 1] = 1;
        }

        for (int k = 3; k <= n; k++) { // k = 길이
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (dp[i + 1][j - 1] == 1 && num[i] == num[j]) {
                    dp[i][j] = 1;
                }
            }
        }


        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(dp[s - 1][e - 1] + "\n");
        }
        bw.close();
    }
}
