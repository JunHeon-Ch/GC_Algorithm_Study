package 프로그래머스.level2.배달;

class Solution {

    public int solution(int N, int[][] road, int K) {
        int[][] g = new int[N + 1][N + 1];
        for(int i = 0; i < road.length; i++) {
            int u = road[i][0];
            int v = road[i][1];
            int c = road[i][2];
            if(g[u][v] != 0) c = Math.min(g[u][v], c);
            g[u][v] = g[v][u] = c;
        }
        boolean[] v = new boolean[N + 1];
        int[][] d = new int[N + 1][N + 1];
        solve(g, v, d, 1, 0, K, N);

        int ans = 0;
        for(int i = 1; i <= N; i++) {
            if(v[i]) ans++;
        }
        return ans;
    }

    private void solve(int[][] g, boolean[] v, int[][] d, int s, int c, int k, int n) {
        if(c > k) return;
        v[s] = true;
        for(int i = 1; i <= n; i++) {
            if(g[s][i] == 0) continue;
            if(d[s][i] == 0 || d[s][i] > c + g[s][i]) {
                d[s][i] = d[i][s] = c + g[s][i];
                solve(g, v, d, i, d[s][i], k, n);
            }
        }
    }
}