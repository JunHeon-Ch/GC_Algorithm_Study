package algo_16926;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, r;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int s = Math.min(n, m) / 2;

        for (int i = 0; i < r; i++) {
            bfs(s);
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                bw.write(map[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.close();
    }

    static void bfs(int s) {
        for (int i = 0; i < s; i++) {
            int dir = 0;
            int sx = i;
            int sy = i;
            int value = map[sx][sy];
            while (dir < 4) {
                int nx = sx + dx[dir];
                int ny = sy + dy[dir];

                if (nx >= i && ny >= i && nx < n - i && ny < m - i) {
                    map[sx][sy] = map[nx][ny];

                    sx = nx;
                    sy = ny;
                } else {
                    dir++;
                }
            }
            map[i + 1][i] = value;
        }
    }
}


