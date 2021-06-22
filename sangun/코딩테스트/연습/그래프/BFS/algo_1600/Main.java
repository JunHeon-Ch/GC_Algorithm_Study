package algo_1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int k, n, m;

    static class Pair {
        int x, y, cnt;

        Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = bfs(map);

        System.out.println(ans);
    }

    static int bfs(int[][] map) {
        Queue<Pair> dq = new LinkedList<>();
        dq.add(new Pair(0, 0, 0));
        int[][][] d = new int[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(d[i][j], -1);
            }
        }
        d[0][0][0] = 0;
        while (!dq.isEmpty()) {
            Pair p = dq.remove();
            int x = p.x;
            int y = p.y;
            int c = p.cnt;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 1) continue;
                    if (c <= k) {
                        if (d[nx][ny][c] == -1) {
                            d[nx][ny][c] = d[x][y][c] + 1;
                            dq.add(new Pair(nx, ny, c));
                        }
                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                int nx = x + hx[i];
                int ny = y + hy[i];
                if (nx >= 0 && nx < n & ny >= 0 && ny < m) {
                    if (map[nx][ny] == 1) continue;
                    if (c + 1 <= k) {
                        if (d[nx][ny][c + 1] == -1) {
                            d[nx][ny][c + 1] = d[x][y][c] + 1;
                            dq.add(new Pair(nx, ny, c + 1));
                        }
                    }
                }
            }

        }
        int min = -1;
        for (int i = 0; i <= k; i++) {
            if (d[n - 1][m - 1][i] == -1) continue;
            if (min == -1 || min > d[n - 1][m - 1][i]) {
                min = d[n - 1][m - 1][i];
            }
        }
        return min;
    }
}
