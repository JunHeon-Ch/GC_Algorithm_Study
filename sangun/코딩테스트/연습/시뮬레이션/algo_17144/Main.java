package algo_17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, t;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        int x1 = -1, y1 = 0, x2 = 0, y2 = 0;
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (x1 == -1) {
                        x1 = i;
                        y1 = j;
                    } else {
                        x2 = i;
                        y2 = j;
                    }
                }
            }
        }
        while (t-- > 0) {
            int[][] copy = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] != -1 && map[i][j] != 0) {
                        int cnt = 4;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            if (nx >= r || nx < 0 || ny >= c || ny < 0) {
                                cnt--;
                                continue;
                            }
                            if (map[nx][ny] == -1) {
                                cnt--;
                                continue;
                            }

                            copy[nx][ny] += map[i][j] / 5;
                        }
                        copy[i][j] += map[i][j] - (map[i][j] / 5) * cnt;
                    }
                }
            }
            // -1
            copy[x1][y1] = -1;
            copy[x2][y2] = -1;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    map[i][j] = copy[i][j];
                }
            }

            // ->
            for (int i = 1; i < c - 1; i++) {
                copy[x1][i + 1] = map[x1][i];
                copy[x2][i + 1] = map[x2][i];
            }
            copy[x1][1] = 0;
            copy[x2][1] = 0;
            // ㅗ
            for (int i = x1; i >= 1; i--) {
                copy[i - 1][c - 1] = map[i][c - 1];
            }
            for (int i = x2; i < r - 1; i++) {
                copy[i + 1][c - 1] = map[i][c - 1];
            }
            // <-
            for (int i = c - 1; i > 0; i--) {
                copy[0][i - 1] = map[0][i];
                copy[r - 1][i - 1] = map[r - 1][i];
            }
            // ㅜ
            for (int i = 0; i < x1; i++) {
                copy[i + 1][0] = map[i][0];
            }
            for (int i = r - 1; i > x2; i--) {
                copy[i - 1][0] = map[i][0];
            }
            copy[x1][y1] = -1;
            copy[x2][y2] = -1;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    map[i][j] = copy[i][j];
                }
            }
        }

        long ans = 2;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans += map[i][j];
            }
        }
        System.out.println(ans);

    }

}
