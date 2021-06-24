package BOJ.코딩테스트.연습.DP.평범한_배낭_12865;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[][] d = new int[n + 1][k + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                d[i][j] = d[i - 1][j];
                if(w[i] <= j) {
                    d[i][j] = Math.max(d[i][j], d[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        bw.write(Integer.toString(d[n][k]));
        bw.flush();
        br.close();
        bw.close();
    }
}
