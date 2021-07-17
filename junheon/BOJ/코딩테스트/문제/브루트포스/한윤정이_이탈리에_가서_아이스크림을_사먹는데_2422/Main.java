package BOJ.코딩테스트.문제.브루트포스.한윤정이_이탈리에_가서_아이스크림을_사먹는데_2422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[][] comb;
    static int[] seq;
    static int ans = 0;

    public static void solve(int index, int start) {
        if (index == 3) {
            ans++;
            return;
        }
        for (int i = start; i <= N; i++) {
            int j;
            for (j = 0; j < index; j++) {
                if (comb[i][seq[j]]) break;
            }
            if (j == index) {
                seq[index] = i;
                solve(index + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        comb = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            comb[u][v] = comb[v][u] = true;
        }
        seq = new int[3];
        solve(0, 1);
        System.out.println(ans);
    }
}
