package algo_2234;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[50][50];
    static int[][] d = new int[50][50];
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] room = new int[2501];

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (d[i][j] == 0) {
                    cnt++;
                    room[cnt] = bfs(i, j, cnt);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 50 * 50; i++) {
            if (ans < room[i]) {
                ans = room[i];
            }
        }
        bw.write(cnt + "\n");
        bw.write(ans + "\n");
        ans =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = i;
                int y = j;
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (d[nx][ny]==d[x][y])continue;
                    if ((map[x][y] & (1 << k)) > 0) {
                        if (ans < room[d[nx][ny]] + room[d[x][y]]) {
                            ans = room[d[nx][ny]] + room[d[x][y]];
                        }
                    }
                }
            }
        }
        bw.write(ans+"\n");
        bw.close();

    }

    static int bfs(int x, int y, int color) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        d[x][y] = color;
        int cnt = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            cnt += 1;
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (d[nx][ny] != 0) continue;
                if ((map[p.x][p.y] & (1 << i)) > 0) continue;
                q.add(new Pair(nx, ny));
                d[nx][ny] = color;
            }
        }
        return cnt;

    }
}
