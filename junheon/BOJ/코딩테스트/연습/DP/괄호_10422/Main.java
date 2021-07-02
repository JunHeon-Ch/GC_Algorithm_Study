// 카탈란 수

package BOJ.코딩테스트.연습.DP.괄호_10422;

import java.io.*;

public class Main {

    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] d = new long[2501];
        d[0] = d[1] = 1;
        for (int i = 2; i <= 2500; i++) {
            for (int j = 0; j < i; j++) {
                d[i] = (d[i] + d[j] * d[i - j - 1] % MOD) % MOD;
            }
        }

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int l = Integer.parseInt(br.readLine());
            if (l % 2 == 1) bw.write(0 + "\n");
            else bw.write(d[l / 2] + "\n");
            t--;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}