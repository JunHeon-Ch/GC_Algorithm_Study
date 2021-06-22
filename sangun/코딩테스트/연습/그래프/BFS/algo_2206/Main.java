package algo_2206;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map, visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class dot {
        int x, y;
        int dist;
        int broken;

        dot(int x, int y, int dist, int broken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken;
        }
    }

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j) - '0';
                visit[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();

        if (ans == Integer.MAX_VALUE) bw.write(-1 + "\n");
        else bw.write(ans + "\n");
        bw.close();
    }


    static void bfs() {
        Queue<dot> q = new LinkedList<>();
        q.offer(new dot(0, 0, 1, 0));
        visit[0][0] = 0;
        while (!q.isEmpty()) {
            dot temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            if (x == n - 1 && y == m - 1) {
                ans = temp.dist;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 공사를 최소로 한 것을 선택 + 지나왔던길 제거
                if (visit[nx][ny] <= temp.broken) continue;

                if (map[nx][ny] != 0) { // 벽일때
                    if (temp.broken == 0) {
                        visit[nx][ny] = temp.broken + 1;
                        q.offer(new dot(nx, ny, temp.dist + 1, temp.broken + 1));
                    }
                } else { // 벽이 아닐때
                    visit[nx][ny] = temp.broken;
                    q.offer(new dot(nx, ny, temp.dist + 1, temp.broken));
                }
            }
        }
    }
}
