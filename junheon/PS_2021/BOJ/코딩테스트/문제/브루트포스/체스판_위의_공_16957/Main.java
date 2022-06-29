package PS_2021.BOJ.코딩테스트.문제.브루트포스.체스판_위의_공_16957;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static int[][] chess;
    static boolean[][] visit;
    static int[][] nr, nc;
    static int[][] count;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        chess = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                chess[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[R][C];
        nr = new int[R + 1][C + 1];
        nc = new int[R + 1][C + 1];
        count = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (nr[i][j] == 0 && nc[i][j] == 0) {
                    solve(i, j);
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                bw.write(count[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] solve(int x, int y) {
        int minX = x, minY = y;
        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx <= 0 || nx > R || ny <= 0 || ny > C) continue;
            if (chess[nx][ny] <= chess[minX][minY]) {
                minX = nx;
                minY = ny;
            }
        }
        if (minX == x && minY == y) {
            nr[x][y] = x;
            nc[x][y] = y;
            count[x][y] = 1;
            return new int[]{x, y};
        }
        if (nr[minX][minY] != 0 && nc[minX][minY] != 0) {
            int nx = nr[minX][minY];
            int ny = nc[minX][minY];
            nr[x][y] = nx;
            nc[x][y] = ny;
            count[nx][ny]++;
            return new int[]{nx, ny};
        }
        int[] res = solve(minX, minY);
        nr[x][y] = res[0];
        nc[x][y] = res[1];
        count[res[0]][res[1]]++;
        return res;
    }
}
