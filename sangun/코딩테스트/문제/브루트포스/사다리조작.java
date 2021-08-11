package 브루트포스;

import java.io.*;
import java.util.StringTokenizer;

public class 사다리조작 {
    static int n, m, h;
    static int[][] map;
    static int ans = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a - 1][b - 1] = 1;
            map[a - 1][b] = 2;
        }

        for (int i = 0; i <= 3; i++) {
            go(i, 0, 0, 0, map);
            if (ans != 4) {
                break;
            }
        }
        if (ans == 4) {
            bw.write(-1 + "");
        } else {
            bw.write(ans + "");
        }
        bw.close();


    }

    static void go(int m, int x, int y, int selected, int[][] p) {
        if (selected == m) {
            if (check(p)) {
                ans = Math.min(ans, m);
            }
            return;
        }
        if (x >= h) {
            return;
        }
        int nx = x;
        int ny = y + 1;
        if (ny >= n) {
            nx++;
            ny = 0;
        }
        // x,y 선택해도 되는지?
        if (map[x][y] != 0 || y + 1 >= n) {
            go(m, nx, ny, selected, p);
        } else if (y + 1 < n && map[x][y + 1] == 1) {
            go(m, nx, ny, selected, p);
        } else {
            p[x][y] = 1;
            p[x][y + 1] = 2;
            go(m, nx, ny, selected + 1, p);
            p[x][y] = 0;
            p[x][y + 1] = 0;
            go(m, nx, ny, selected, p);
        }

    }

    static boolean check(int[][] map) {
        for (int i = 0; i < n; i++) {
            int x = 0, y = i;
            for (int j = 0; j < h; j++) {
                if (map[x][y] == 1) y++;
                else if (map[x][y] == 2) y--;
                x++;
            }
            if (y != i) return false;
        }
        return true;
    }


}
