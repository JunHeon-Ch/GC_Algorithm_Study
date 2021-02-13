package algo_14500;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visit[i][j] = false;
                last(i, j, map[i][j]);
            }
        }
        bw.write(max + "\n");
        bw.close();


    }

    static void dfs(int x, int y, int cnt, int sum) {

        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (visit[nx][ny]) continue;
            visit[nx][ny] = true;
            dfs(nx, ny, cnt + 1, sum + map[nx][ny]);
            visit[nx][ny] = false;
        }
    }

    // ㅗ 모양
    static void last(int x, int y, int sum) {
        int[] temp = new int[4];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            temp[i] = map[nx][ny];
        }
        for (int i = 0; i < 4; i++) {
            int ans = sum + temp[i] + temp[(i + 1) % 4] + temp[(i + 2) % 4];
            max = Math.max(max, ans);
        }
    }
}
