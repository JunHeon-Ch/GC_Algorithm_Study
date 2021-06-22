package algo_6087;

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

    static int w, h;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static dot c1, c2;
    static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];


        boolean check = false;
        for (int i = 0; i < h; i++) {
            String str = br.readLine();
            for (int j = 0; j < w; j++) {
                if (str.charAt(j) == '*') {
                    map[i][j] = 1;
                } else if (str.charAt(j) == '.') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 0;
                    if (check) c2 = new dot(i, j);
                    else {
                        c1 = new dot(i, j);
                        check = true;
                    }
                }
            }
        }


        bw.write(bfs(c1) - 1 + "\n");
        bw.close();

    }

    static int bfs(dot c) {
        Queue<dot> q = new LinkedList<>();
        q.add(c);
        int[][] d = new int[h][w];

        while (!q.isEmpty()) {
            dot temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];

                while (x < h && x >= 0 && y < w && y >= 0) {
                    if (map[x][y] == 1) break;
                    if (d[x][y] == 0) {
                        q.add(new dot(x, y));
                        d[x][y] = 1 + d[temp.x][temp.y];
                    }
                    x += dx[i];
                    y += dy[i];

                }

            }
        }
        return d[c2.x][c2.y];
    }

}
