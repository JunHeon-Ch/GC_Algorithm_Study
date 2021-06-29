package BOJ.코딩테스트.연습.DP.기타리스트_1495;

import java.io.*;
import java.util.StringTokenizer;

public class Main_Fail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] v = new int[n];
        int i = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            v[i++] = Integer.parseInt(st.nextToken());
        }

        int[][] d = new int[n + 1][2];
        d[0][0] = d[0][1] = s;
        boolean flag = false;
        for (i = 1; i <= n; i++) {
            int v1 = d[i - 1][0] - v[i - 1];
            int v2 = d[i - 1][1] - v[i - 1];
            if (v1 >= 0 && v2 >= 0) d[i][0] = Math.max(v1, v2);
            else if(v1 < 0 && v2 >= 0) d[i][0] = v2;
            else if(v1 >= 0 && v2 < 0) d[i][0] = v1;
            else d[i][0] = -1;

            v1 = d[i - 1][0] + v[i - 1];
            v2 = d[i - 1][1] + v[i - 1];
            if (v1 <= m && v2 <= m) d[i][1] = Math.max(v1, v2);
            else if(v1 > m && v2 <= m) d[i][1] = v2;
            else if(v1 <= m && v2 > m) d[i][1] = v1;
            else d[i][1] = -1;

            if(d[i][0] == -1 && d[i][1] == -1) {
                bw.write(Integer.toString(-1));
                flag = true;
                break;
            }
        }
        if(!flag) bw.write(Integer.toString(Math.max(d[n][0], d[n][1])));
        bw.flush();
        bw.close();
        br.close();
    }

}
