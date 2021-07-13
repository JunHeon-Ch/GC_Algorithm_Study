package algo_7576;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<dot> dot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        dot = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) dot.add(new dot(i, j));
            }
        }
        bfs(map, n, m);
        boolean check = false;
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    max = -1;
                    check = true;
                    break;
                }
                if (map[i][j] > max) max = map[i][j];

            }
            if (check) break;
        }
        if (max != -1) max--;
        bw.write(max + "\n");
        bw.close();

    }

    static void bfs(int[][] map, int n, int m) {
        while (!dot.isEmpty()) {
            dot temp = dot.poll();
            for (int i = 0; i < 4; i++) {
                int x1 = temp.getX() + dx[i];
                int y1 = temp.getY() + dy[i];
                if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m) {
                    if (map[x1][y1] == 0) {
                        dot.add(new dot(x1, y1));
                        map[x1][y1] = map[temp.x][temp.y] + 1;
                    }
                }
            }
        }
    }
}

class dot {
    int x, y;

    public dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}


