package algo_2146;

import java.io.*;
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

    static Queue<dot> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int n, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        q = new LinkedList<>();
        map = new int[n][n];
        visited = new boolean[n][n];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        numbering();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) continue;

                q.clear();
                visited = new boolean[n][n];
                q.offer(new dot(i, j));
                visited[i][j] = true;

                int dist = find(map[i][j]);

                if (dist == -1) continue;

                ans = Math.min(ans, dist);
            }
        }

        bw.write(ans + "\n");
        bw.close();
    }

    private static int find(int start) {
        int dist = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                dot temp = q.poll();
                if (map[temp.x][temp.y] != 0 && map[temp.x][temp.y] != start) return dist;
                for (int j = 0; j < 4; j++) {
                    int x = temp.x + dx[j];
                    int y = temp.y + dy[j];
                    if (x < 0 || x >= n || y < 0 || y >= n) continue;
                    if (visited[x][y] || map[x][y] == start) continue;
                    q.offer(new dot(x, y));
                    visited[x][y] = true;
                }
            }
            dist++;
        }

        return -1;
    }

    private static void numbering() {
        int number = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || map[i][j] == 0) continue;
                map[i][j] = number;
                q.offer(new dot(i, j));
                visited[i][j] = true;

                while (!q.isEmpty()) {
                    dot temp = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int x = temp.x + dx[k];
                        int y = temp.y + dy[k];
                        if (x < 0 || x >= n || y < 0 || y >= n ||
                                visited[x][y] || map[x][y] == 0) continue;
                        if (map[x][y] == 1) {
                            q.offer(new dot(x, y));
                            map[x][y] = number;
                            visited[x][y] = true;
                        }
                    }
                }
                number++;
            }
        }
    }
}