package algo_14391;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] num = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                num[i][j] = str.charAt(j) - '0';
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int s = 0; s < (1 << n * m); s++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int cur = 0;
                for (int j = 0; j < m; j++) {
                    int k = i * m + j;
                    if ((s & (1 << k)) == 0) {
                        cur = cur * 10 + num[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;

            }
            for (int j = 0; j < m; j++) {
                int cur = 0;
                for (int i = 0; i < n; i++) {
                    int k = i * m + j;
                    if ((s & (1 << k)) != 0) {
                        cur = cur * 10 + num[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            ans = Math.max(ans, sum);
        }

        bw.write(ans + "\n");
        bw.close();

    }
}
