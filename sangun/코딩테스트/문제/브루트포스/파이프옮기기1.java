package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기1 {
    static int n;
    static int[][] map;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0, 1, 0);

        System.out.println(ans);
    }

    static void go(int x, int y, int dir) {
        if (x >= n || y >= n) return;
        if (map[x][y] == 1) return;
        if (x == n - 1 && y == n - 1) {
            ans++;
            return;
        }
        // 가로
        if (dir == 0) {
            go(x, y + 1, 0);
            if (!(map[x][y + 1] == 1 || map[x + 1][y] == 1)) {
                go(x + 1, y + 1, 2);
            }

        } else if (dir == 1) {// 세로
            go(x + 1, y, 1);
            if (!(map[x][y + 1] == 1 || map[x + 1][y] == 1)) {
                go(x + 1, y + 1, 2);
            }


        } else if (dir == 2) { // 대각선
            go(x, y + 1, 0);
            go(x + 1, y, 1);
            if (!(map[x][y + 1] == 1 || map[x + 1][y] == 1)) {
                go(x + 1, y + 1, 2);
            }
        }
    }


}
