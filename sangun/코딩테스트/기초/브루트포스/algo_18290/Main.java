package algo_18290;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n, m;
    static boolean[][] visit;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0, 0, k, 0);
        bw.write(max + "\n");
        bw.close();


    }

    static void go(int x, int y, int cnt, int sum) {
        if (cnt == 0) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = x; i < n; i++) {
            for (int j = y; j < m; j++) {
                if (!valid(i, j)) continue;
                visit[i][j] = true;
                go(x, y, cnt - 1, sum + map[i][j]);
                visit[i][j] = false;
            }
        }
    }

    static boolean valid(int x, int y) {
        for (int k = 0; k < 5; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= n || nx < 0 || ny >= m || ny < 0) continue;
            if (visit[nx][ny]) return false;
        }
        return true;
    }
}
