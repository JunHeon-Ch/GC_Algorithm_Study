package algo_16946;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int numbering = 1;
    static int[] color = new int[1000001];

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
        ArrayList<dot> wall = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
                if (map[i][j] == 1) {
                    wall.add(new dot(i, j));
                }
            }
        }
        int[][] ans = new int[n][m];
        int z = 0;
        for (int[] k : map) {
            ans[z] = k.clone();
            z++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    numbering++;
                    map[i][j] = numbering;
                    bfs(i, j);
                }
            }
        }


        for (int i = 0; i < wall.size(); i++) {
            dot temp = wall.get(i);
            int nx = temp.x;
            int ny = temp.y;
            HashSet<Integer> set = new HashSet<>();
            for (int k = 0; k < 4; k++) {
                int x = nx + dx[k];
                int y = ny + dy[k];
                if (x < 0 || x >= n || y < 0 || y >= m) continue;
                if (map[x][y] == 1) continue;
                if (set.contains(map[x][y])) continue;
                ans[nx][ny] += (color[map[x][y]] % 10);
                set.add(map[x][y]);
            }
            ans[nx][ny] %= 10;


        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(ans[i][j] + "");
            }
            bw.write("\n");
        }
        bw.close();
    }

    static void bfs(int x, int y) {
        Queue<dot> q = new LinkedList<>();
        q.offer(new dot(x, y));
        int cnt = 0;
        while (!q.isEmpty()) {
            dot temp = q.poll();
            int tx = temp.x;
            int ty = temp.y;
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (map[nx][ny] != 0) continue;
                map[nx][ny] = numbering;
                q.offer(new dot(nx, ny));
            }
        }
        color[numbering] = cnt;
    }
}
