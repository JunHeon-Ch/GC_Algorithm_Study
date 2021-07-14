package algo_16929;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean ans = false;
    static int ax, ay;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ax = i;
                ay = j;
                dfs(n, m, i, j, map, 1);
                if (ans) {
                    bw.write("Yes\n");
                    bw.close();
                    return;
                }
            }
        }
        bw.write("No\n");
        bw.close();

    }

    static void dfs(int n, int m, int x, int y, char[][] map, int cnt) {
        if (ans) return;
        if (map[x][y] == '0') {
            if (cnt >= 4) {
                ans = true;
            }
            return;
        }
        cnt++;
        char temp = map[x][y];
        map[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m) {
                if (temp == map[x1][y1] || (ax == x1 && ay == y1)) {
                    dfs(n, m, x1, y1, map, cnt);
                }
            }
        }
        map[x][y] = temp;
    }
}
