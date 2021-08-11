package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 십자가2개놓기 {
    static int n, m;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        boolean[][] v = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        go(v, 0, 0, 0);
        System.out.println(ans);

    }

    static void go(boolean[][] visited, int size1, int size2, int cnt) {
        if (cnt == 2) {
            ans = Math.max(ans, size1 * size2);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '.') continue;
                boolean[][] visitNew = new boolean[n][m];

                copy(visited, visitNew);
                int len = 0;
                while (isPossible(visited, i, j, len)) {
                    check(visitNew, i, j, len);
                    if (cnt == 0) {
                        size1 = 4 * len + 1;
                    }
                    if (cnt == 1) {
                        size2 = 4 * len + 1;
                    }
                    len++;
                    go(visitNew, size1, size2, cnt + 1);

                }

            }
        }
    }

    static boolean isPossible(boolean[][] v, int x, int y, int len) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i] * len;
            int ny = y + dy[i] * len;
            if (nx >= n || ny >= m || nx < 0 || ny < 0) return false;
            if (map[nx][ny] == '.') return false;
            if (v[nx][ny]) return false;
        }
        return true;
    }

    static void check(boolean[][] v, int x, int y, int len) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i] * len;
            int ny = y + dy[i] * len;
            v[nx][ny] = true;
        }
    }

    static void copy(boolean[][] old, boolean[][] newN) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newN[i][j] = old[i][j];
            }
        }
    }

}
