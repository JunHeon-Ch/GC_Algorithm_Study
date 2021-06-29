package BOJ.코딩테스트.연습.DP.기타리스트_1495;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] v = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        int i = 1;
        while(st.hasMoreTokens()) {
            v[i++] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int[] d = new int[m + 1];
        Arrays.fill(d, -1);
        d[s] = 0;
        int cnt = 0;
        for(i = 1; i <= n; i++) {
            cnt = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j <= m; j++) {
                if(d[j] == i - 1) {
                    int v1 = j - v[i];
                    int v2 = j + v[i];
//                    if(v1 >= 0 && v1 <= m) d[v1] = i;
//                    if(v2 >= 0 && v2 <= m) d[v2] = i;
                    if(v1 >= 0 && v1 <= m) list.add(v1);
                    if(v2 >= 0 && v2 <= m) list.add(v2);
                    cnt++;
                }
            }
            if(cnt == 0) break;
            for(int vol : list) {
                d[vol] = i;
            }
        }

        int ans = -1;
        if(cnt != 0) {
            for(i = 0; i <= m; i++) {
                if(d[i] == n) ans = Math.max(ans, i);
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
