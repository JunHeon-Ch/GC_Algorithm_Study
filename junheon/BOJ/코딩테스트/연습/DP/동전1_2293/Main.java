package BOJ.코딩테스트.연습.DP.동전1_2293;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        int[] d = new int[k + 1];
        d[0] = 1;
        for(int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            for(int j = coin[i]; j <= k; j++) {
                d[j] += d[j - coin[i]];
            }
        }
        bw.write(d[k] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
