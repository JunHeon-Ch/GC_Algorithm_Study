package algo_10942;

import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    static int[][] dp;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(dp(s - 1, e - 1) + "\n");
        }
        bw.close();
    }

    static int dp(int i, int j) {
        if (i == j) {
            return dp[i][j] = 1;
        } else if (i + 1 == j) {
            if (num[i] == num[j]) return 1;
            else return 0;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        if (num[i] != num[j]) return dp[i][j] = 0;
        else return dp[i][j] = dp(i + 1, j - 1);
    }
}
