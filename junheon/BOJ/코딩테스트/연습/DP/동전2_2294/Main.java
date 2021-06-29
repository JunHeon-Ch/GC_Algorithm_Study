package BOJ.코딩테스트.연습.DP.동전2_2294;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] d = new int[k + 1];
        Arrays.fill(d, -1);
        d[0] = 0;
        for(int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            for(int j = coin; j <= k; j++) {
                if (d[j - coin] != -1) {
                    if(d[j] == -1) d[j] = d[j - coin] + 1;
                    else d[j] = Math.min(d[j], d[j - coin] + 1);
                }
            }
        }
        bw.write(d[k] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
