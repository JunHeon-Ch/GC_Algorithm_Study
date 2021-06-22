package algo_17086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] dist;
    static int[][] map;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n][m];
        map = new int[n][m];

        ArrayList<Pair> point = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    point.add(new Pair(i, j));
                }
            }
        }

        for (int[] k : dist) {
            Arrays.fill(k, Integer.MAX_VALUE);
        }
        for (int i = 0; i < point.size(); i++) {
            bfs(point.get(i).x, point.get(i).y);

        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] != -1 && dist[i][j] > ans) {
                    ans = dist[i][j];
                }
            }
        }


        System.out.println(ans);


    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        dist[x][y] = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 1) continue;
                    if (dist[p.x][p.y] + 1 < dist[nx][ny]) {
                        dist[nx][ny] = dist[p.x][p.y] + 1;
                        q.add(new Pair(nx, ny));
                    }
                }

            }
        }
    }
}
