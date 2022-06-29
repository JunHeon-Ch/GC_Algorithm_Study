// 카탈란 수

package PS_2021.BOJ.코딩테스트.연습.DP.괄호_10422;

import java.io.*;

public class Main_fail {

    static final int MOD = 1000000007;
    static int[][] d = new int[5001][2501];

    public static int combination(int n, int r) {
        if (n == r || r == 0) return 1;
        if (d[n][r] > 0) return d[n][r];
        d[n][r] = (combination(n - 1, r - 1) % MOD + combination(n - 1, r) % MOD) % MOD;
        return d[n][r];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] ans = new int[2501];
        for (int i = 0; i <= 2500; i++) {
            ans[i] = (int)((double)1 / (i + 1) * combination(2 * i, i));
        }

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int l = Integer.parseInt(br.readLine());
            if (l % 2 == 1) bw.write(0 + "\n");
            else {
                l /= 2;
                bw.write(ans[l] + "\n");
            }
            t--;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
