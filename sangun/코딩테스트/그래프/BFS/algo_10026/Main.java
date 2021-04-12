package algo_10026;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static char[][] map;
    static int[][] visit;
    static int color1 = 0;
    static int color2 = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

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

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visit = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == 0) {
                    numbering(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }
        visit = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == 0) {
                    numbering2(i, j);
                }
            }
        }
        bw.write(color1 + " " + color2 + "\n");
        bw.close();


    }

    static void numbering(int x, int y) {
        Queue<dot> q = new LinkedList<>();
        q.add(new dot(x, y));
        color1++;
        visit[x][y] = color1;
        while (!q.isEmpty()) {
            dot temp = q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx >= n || nx < 0 || ny >= n || ny < 0) continue;
                if (visit[nx][ny] != 0) continue;
                if (map[x][y] != map[nx][ny]) continue;
                q.add(new dot(nx, ny));
                visit[nx][ny] = color1;
            }
        }
    }

    static void numbering2(int x, int y) {
        Queue<dot> q = new LinkedList<>();
        q.add(new dot(x, y));
        color2++;
        visit[x][y] = color2;
        while (!q.isEmpty()) {
            dot temp = q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx >= n || nx < 0 || ny >= n || ny < 0) continue;
                if (visit[nx][ny] != 0) continue;
                if (map[x][y] != map[nx][ny]) continue;
                q.add(new dot(nx, ny));
                visit[nx][ny] = color2;
            }
        }
    }
}
