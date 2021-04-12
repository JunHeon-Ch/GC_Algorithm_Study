package algo_17142;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] map;
    static ArrayList<Pair> virus = new ArrayList<>();
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new Pair(i, j));
                }
            }
        }

        go(0, 0);
        System.out.println(ans);
    }

    static void go(int index, int cnt) {
        if (index == virus.size()) {
            if (cnt == m) {
                bfs();
            }
        } else {
            Pair p = virus.get(index);
            map[p.x][p.y] = 3;
            go(index + 1, cnt + 1);
            map[p.x][p.y] = 2;
            go(index + 1, cnt);
        }
    }

    static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        int[][] d = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = -1;
                if (map[i][j] == 3) {
                    q.add(new Pair(i, j));
                    d[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= n || nx < 0 || ny >= n || ny < 0) continue;
                if (map[nx][ny] == 1) continue;
                if (d[nx][ny] != -1) continue;
                q.add(new Pair(nx, ny));
                d[nx][ny] = d[p.x][p.y] + 1;
            }
        }
        int min = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    if (d[i][j] == -1) {
                        return;
                    }
                    if (min < d[i][j]) {
                        min = d[i][j];
                    }
                }
            }
        }
        if (ans == -1 || ans > min) {
            ans = min;
        }
    }
}
