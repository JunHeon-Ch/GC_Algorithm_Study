package algo_14502;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<dot> v = new ArrayList<>();
    static int[][] map;
    static int ans = Integer.MIN_VALUE;
    static int[][] temp;

    static class dot {
        int x, y;

        dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    v.add(new dot(i, j));
                }
            }
        }
        temp = new int[n][m];
        int z = 0;
        for (int[] k : map) {
            temp[z] = k.clone();
            z++;
        }
        dfs(0, 0);
        bw.write(ans + "\n");
        bw.close();

    }

    static void bfs() {
        Queue<dot> q = new LinkedList<>();
        for (int i = 0; i < v.size(); i++) {
            q.offer(v.get(i));
        }
        while (!q.isEmpty()) {
            dot temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= n || nx < 0 || ny >= m || ny < 0) continue;
                if (map[nx][ny] != 0) continue;
                map[nx][ny] = 2;
                q.offer(new dot(nx, ny));
            }
        }
        count();

    }

    static void count() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) cnt++;
            }
        }
        ans = Math.max(ans, cnt);
    }

    static void dfs(int x, int cnt) {
        if (cnt == 3) {
            int z = 0;
            for (int[] k : map) {
                temp[z] = k.clone();
                z++;
            }
            bfs();
            z = 0;
            for (int[] k : temp) {
                map[z] = k.clone();
                z++;
            }
            return;
        }

        for (int i = x; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(i, cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

}
