package PS_2021.BOJ.코딩테스트.문제.브루트포스.치킨_배달_15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, hCnt = 0, cCnt = 0;
    static int[] hr, hc, cr, cc;
    static boolean[] visit;
    static int ans = Integer.MAX_VALUE;

    public static int minDist() {
        int res = 0;
        for(int i = 0; i < hCnt; i++) {
            int dist = Integer.MAX_VALUE;
            for(int j = 0; j < cCnt; j++) {
                if(visit[j]) {
                    int d = Math.abs(cr[j] - hr[i]) + Math.abs(cc[j] - hc[i]);
                    dist = Math.min(dist, d);
                }
            }
            res += dist;
        }
        return res;
    }

    public static void solve(int index, int selected) {
        if(selected == M) {
            int res = minDist();
            ans = Math.min(ans, res);
            return;
        }
        if(index >= cCnt) return;
        visit[index] = true;
        solve(index + 1, selected + 1);
        visit[index] = false;
        solve(index + 1, selected);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        hr = new int[2 * N];
        hc = new int[2 * N];
        cr = new int[13];
        cc = new int[13];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int g = Integer.parseInt(st.nextToken());
                if(g == 1) {
                    hr[hCnt] = i; hc[hCnt] = j;
                    hCnt++;
                } else if(g == 2) {
                    cr[cCnt] = i; cc[cCnt] = j;
                    cCnt++;
                }
            }
        }

        visit = new boolean[cCnt];
        solve(0, 0);
        System.out.println(ans);
    }
}
