package algo_9095;

import java.io.*;

public class Main {
    static int[] dp = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            bw.write(go(temp)+"\n");
        }
        bw.close();

    }

    static int go(int n) {
        if (n <= 0) {
            return 0;
        }if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = go(n - 1) + go(n - 2) + go(n - 3);

    }
}
