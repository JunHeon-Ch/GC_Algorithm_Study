package BOJ.코딩테스트.문제.브루트포스.게리맨더링_17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] population;
    static boolean[][] connect;
    static boolean[] group;
    static boolean[] visit;
    static int ans = -1;

    // DFS
    public static boolean connectionCheck(int s, int e) {
        visit[s] = true;
        for (int n = 1; n <= N; n++) {
            if (visit[n] || !connect[s][n] || group[n] != group[s]) continue;
            if (connect[s][n] && n == e) return true;
            if (connectionCheck(n, e)) return true;
        }
        return false;
    }

    public static boolean groupCheck() {
        for (int i = 1; i <= N; i++) {
            boolean g = group[i];
            for (int j = i + 1; j <= N; j++) {
                // 그룹이 다른 경우
                if (group[j] != g) continue;
                // 그룹이 같고 직접적인 연결되어 있는 경우
                if (connect[i][j]) continue;
                // 그룹이 같고 직접적인 연결이 안 되어 있는 경우
                visit = new boolean[N + 1];
                if (!connectionCheck(i, j)) return false;
            }
        }
        return true;
    }

    public static void solve(int max, int count, int start) {
        if (count == max) {
            if (groupCheck()) {
                int g1 = 0, g2 = 0;
                for (int i = 1; i <= N; i++) {
                    if (group[i]) g1 += population[i];
                    else g2 += population[i];
                }
                int res = Math.abs(g1 - g2);
                if (ans == -1 || ans > res) ans = res;
            }
            return;
        }
        for (int i = start + 1; i <= N; i++) {
            if (!group[i]) {
                group[i] = true;
                solve(max, count + 1, i);
                group[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        population = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        connect = new boolean[N + 1][N + 1];
        for (int u = 1; u <= N; u++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken());
                connect[u][v] = connect[v][u] = true;
            }
        }

        group = new boolean[N + 1];
        for (int i = 1; i < N; i++) {
            solve(i, 0, 0);
        }
        System.out.println(ans);
    }
}
