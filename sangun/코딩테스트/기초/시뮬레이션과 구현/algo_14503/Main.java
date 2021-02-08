package algo_14503;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 0 북, 1 동, 2 남, 3 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static boolean[][] visited;
    static int[][] map;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(x, y, d);
        bw.write(ans + "\n");
        bw.close();

    }

    static void go(int x, int y, int dir) {
        switch (map[x][y]) {
            case 1:
                return;
            case 0:
                map[x][y] = -1;
                ans++;
        }
        int d = dir;
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (map[nx][ny] == 0) {
                go(nx, ny, d);
                return;
            }
        }
        go(x - dx[dir], y - dy[dir], dir);
        return;
    }
}


