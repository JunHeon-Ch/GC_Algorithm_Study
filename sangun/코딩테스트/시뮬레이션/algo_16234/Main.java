package algo_16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, l, r;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (true) {
            ans++;
            d = new int[n][n];
            int color = 0;
            ArrayList<Integer> c = new ArrayList<>();
            c.add(0, 0);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (d[i][j] == 0) {
                        color++;
                        c.add(color, bfs(i, j, color));
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = c.get(d[i][j]);
                }
            }
            if (d[n - 1][n - 1] == n * n) break;

        }


        System.out.println(ans - 1);
    }

    static int bfs(int x, int y, int color) {
        int sum = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        d[x][y] = color;
        int cnt = 0;
        while (!q.isEmpty()) {
            Pair tmp = q.remove();
            sum += map[tmp.x][tmp.y];
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= n || nx < 0 || ny >= n || ny < 0) continue;
                if (d[nx][ny] != 0) continue;
                int value = Math.abs(map[tmp.x][tmp.y] - map[nx][ny]);
                if (value <= r && value >= l) {
                    d[nx][ny] = color;
                    q.add(new Pair(nx, ny));
                }
            }
        }
        return sum / cnt;
    }
}
