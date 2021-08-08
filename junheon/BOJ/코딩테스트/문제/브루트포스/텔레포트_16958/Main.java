package BOJ.코딩테스트.문제.브루트포스.텔레포트_16958;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, T;
    static int[] r, c;
    static boolean[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        r = new int[N + 1];
        c = new int[N + 1];
        s = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) s[i] = true;
            else s[i] = false;
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int ans = Math.abs(r[start] - r[end]) + Math.abs(c[start] - c[end]);
            if(s[start] && s[end]) {
                ans = Math.min(ans, T);
            } else if(!s[start] && s[end]) {
                int res = getMinDist(start, end);
                ans = Math.min(ans, res + T);
            } else if(s[start] && !s[end]) {
                int res= getMinDist(end, start);
                ans = Math.min(ans, res + T);
            } else if(!s[start] && !s[end]) {
                int res1 = getMinDist(start, end);
                int res2 = getMinDist(end, start);
                if(res1 != Integer.MAX_VALUE && res2 != Integer.MAX_VALUE) {
                    ans = Math.min(ans, res1 + res2 + T);
                }
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getMinDist(int start, int end) {
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            if(i != end && s[i]) {
                min = Math.min(min, Math.abs(r[start] - r[i]) + Math.abs(c[start] - c[i]));
            }
        }
        return min;
    }
}
