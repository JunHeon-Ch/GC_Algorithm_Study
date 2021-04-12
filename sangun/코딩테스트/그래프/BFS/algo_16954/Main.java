package algo_16954;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    // 3차원으로 다시 해보기!
    static class dot {
        int x, y;

        dot(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

    static int cnt = 0;
    static int ans = 0;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1, 0};

    static char[][] map = new char[8][8];
//    static boolean[][] visit = new boolean[8][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        bfs();
        bw.write(ans + "\n");
        bw.close();

    }

    static void bfs() {
        Queue<dot> q = new LinkedList<>();
        q.offer(new dot(7, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int t = 0; t < size; t++) {

                dot temp = q.poll();
                int x = temp.x;
                int y = temp.y;
                if (x == 0 && y == 7) {
                    ans = 1;
                    return;
                }
                if (map[x][y] == '#') continue;
//                visit[x][y] = true;
                for (int i = 0; i < 9; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 8 || nx < 0 || ny >= 8 || ny < 0) continue;
//                    if (visit[nx][ny]) continue;
                    if (map[nx][ny] == '#') continue;
                    q.offer(new dot(nx, ny));
                }
            }
            if (cnt >= 8) continue;
            move();
            cnt++;

        }
    }

    static void move() {

        for (int i = 7; i > cnt; i--) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = map[i - 1][j];
            }
        }
        for (int i = 0; i <= cnt; i++) {
            map[i] = new char[8];
        }
    }
}
