package PS_2021.BOJ.코딩테스트.문제.브루트포스.두_스티커_16937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int[] r = new int[N];
        int[] c = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int area = r[i] * c[i] + r[j] * c[j];
                // W 기준
                // i 가로 + j 가로
                if(r[i] + r[j] <= W && c[i] <= H && c[j] <= H) {
                    ans = Math.max(ans, area);
                    continue;
                }
                // i 가로 + j 세로
                if(r[i] + c[j] <= W && c[i] <= H && r[j] <= H) {
                    ans = Math.max(ans, area);
                    continue;
                }
                // i 세로 + j 가로
                if(c[i] + r[j] <= W && r[i] <= H && c[j] <= H) {
                    ans = Math.max(ans, area);
                    continue;
                }
                // i 세로 + j 세로
                if(c[i] + c[j] <= W && r[i] <= H && r[j] <= H) {
                    ans = Math.max(ans, area);
                    continue;
                }
                // H 기준
                // i 가로 + j 가로
                if(r[i] + r[j] <= H && c[i] <= W && c[j] <= W) {
                    ans = Math.max(ans, area);
                    continue;
                }
                // i 가로 + j 세로
                if(r[i] + c[j] <= H && c[i] <= W && r[j] <= W) {
                    ans = Math.max(ans, area);
                    continue;
                }
                // i 세로 + j 가로
                if(c[i] + r[j] <= H && r[i] <= W && c[j] <= W) {
                    ans = Math.max(ans, area);
                    continue;
                }
                // i 세로 + j 세로
                if(c[i] + c[j] <= H && r[i] <= W && r[j] <= W) {
                    ans = Math.max(ans, area);
                    continue;
                }
            }
        }
        System.out.println(ans);
    }
}
