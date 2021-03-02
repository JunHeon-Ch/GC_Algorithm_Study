package algo_14442;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int[][] map;
    static boolean visit[][][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans = -1;

    static class dot {
        int x, y, dist, broken;

        dot(int x, int y, int dist, int broken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        bfs();

        bw.write(ans + "\n");
        bw.close();
    }

    static void bfs() {
        Queue<dot> q = new LinkedList<>();
        q.offer(new dot(0, 0, 1, 0));
        visit[0][0][0] = true;
        while (!q.isEmpty()) {
            dot temp = q.poll();
            if (temp.x == n - 1 && temp.y == m - 1) {
                ans = temp.dist;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 이동할 수 있는 곳으로 이동할 경우
                if (map[nx][ny] == 0) {
                    // 이미 왔던 길일 경우 pass
                    if (visit[nx][ny][temp.broken]) continue;
                    q.add(new dot(nx, ny, temp.dist + 1, temp.broken));
                    visit[nx][ny][temp.broken] = true;
                }
                // 벽을 부수고 이동해야할 경우
                else {
                    // 더이상 벽을 부술 수 없거나,
                    if (temp.broken >= k) continue;
                    // 이미 왔던 길일 경우 pass
                    if (visit[nx][ny][temp.broken + 1]) continue;
                    // 벽을 부술 수 있다면 부수고 이동
                    q.add(new dot(nx, ny, temp.dist + 1, temp.broken + 1));
                    visit[nx][ny][temp.broken + 1] = true;

                }
            }
        }
    }
}
