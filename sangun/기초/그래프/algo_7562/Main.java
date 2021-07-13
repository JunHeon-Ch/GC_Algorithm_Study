package algo_7562;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int l = 0;
        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());
            Queue<dot> q = new LinkedList<>();
            q.add(new dot(a, b));
            int[][] map = new int[l][l];
            map[a][b] = 1;
            bfs(l, map, q);
            bw.write(map[tx][ty] - 1 + "\n");
        }
        bw.close();
    }

    static void bfs(int l, int[][] map, Queue<dot> q) {
        while (!q.isEmpty()) {
            dot temp = q.poll();
            for (int i = 0; i < 8; i++) {
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if (x >= 0 && x < l && y >= 0 && y < l) {
                    if (map[x][y] == 0) {
                        map[x][y] = map[temp.x][temp.y] + 1;
                        q.add(new dot(x, y));
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
}

