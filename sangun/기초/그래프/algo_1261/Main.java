package algo_1261;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class dot {
        int x, y;

        dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] visited = new int[n][m];
        for (int[] k : visited) {
            Arrays.fill(k, -1);
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        bfs(n, m, map, visited);
        bw.write(visited[n - 1][m - 1] + "\n");
        bw.close();

    }

    static void bfs(int n, int m, int[][] map, int[][] visited) {
        Queue<dot> q = new LinkedList<>();
        q.add(new dot(0, 0));
        visited[0][0] = 0;
        while (!q.isEmpty()) {
            dot temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            for (int i = 0; i < 4; i++) {
                int x1 = x + dx[i];
                int y1 = y + dy[i];
                if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) continue;

                if (map[x1][y1] == 1) {
                    if (visited[x1][y1] > visited[x][y] + 1 || visited[x1][y1] == -1) {
                        visited[x1][y1] = visited[x][y] + 1;
                        q.add(new dot(x1, y1));
                    }
                } else if (map[x1][y1] == 0) {
                    if (visited[x1][y1] > visited[x][y] || visited[x1][y1] == -1) {
                        visited[x1][y1] = visited[x][y];
                        q.add(new dot(x1, y1));
                    }
                }
            }


        }

    }
}
