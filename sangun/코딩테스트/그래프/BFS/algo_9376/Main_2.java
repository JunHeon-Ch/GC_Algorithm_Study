package algo_9376;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2 {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = -1, y = -1;

            String[] map = new String[n + 2];
            for (int i = 1; i <= n; i++) {
                map[i] = br.readLine();
                map[i] = "." + map[i] + ".";
            }
            n += 2;
            m += 2;
            map[0] = map[n - 1] = "";
            for (int j = 0; j < m; j++) {
                map[0] += ".";
                map[n - 1] += ".";
            }
            int[][] d0 = bfs(map, 0, 0);
            int x1, y1, x2, y2;
            x1 = y1 = x2 = y2 = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i].charAt(j) == '$') {
                        if (x1 == -1) {
                            x1 = i;
                            y1 = j;
                        } else {
                            x2 = i;
                            y2 = j;
                        }
                    }
                }
            }
            int[][] d1 = bfs(map, x1, y1);
            int[][] d2 = bfs(map, x2, y2);
            int ans = n * m;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    char c = map[i].charAt(j);
                    if (c == '*') continue;
                    if (d0[i][j] == -1 || d1[i][j] == -1 || d2[i][j] == -1) continue;
                    int cur = d0[i][j] + d1[i][j] + d2[i][j];
                    if (c == '#') cur -= 2;
                    if (ans > cur) ans = cur;
                }
            }
            bw.write(ans + "\n");
        }
        bw.close();

    }

    static int[][] bfs(String[] a, int x, int y) {
        int n = a.length;
        int m = a[0].length();
        int[][] d = new int[n][m];
        for (int[] k : d) {
            Arrays.fill(k, -1);
        }
        ArrayDeque<Pair> dq = new ArrayDeque<>();
        dq.add(new Pair(x, y));
        d[x][y] = 0;
        while (!dq.isEmpty()) {
            Pair p = dq.remove();
            x = p.x;
            y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (d[nx][ny] != -1) continue;
                char c = a[nx].charAt(ny);
                if (c == '*') continue;
                if (c == '#') {
                    d[nx][ny] = d[x][y] + 1;
                    dq.addLast(new Pair(nx, ny));
                } else {
                    d[nx][ny] = d[x][y];
                    dq.addFirst(new Pair(nx, ny));
                }
            }
        }
        return d;
    }
}
