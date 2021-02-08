package algo_16931;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 2 * n * m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = map[i][j] * 4;
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x < 0 || x >= n || y < 0 || y >= m) continue;
                    if (map[x][y] > map[i][j]) {
                        cnt -= map[i][j];
                    } else {
                        cnt -= map[x][y];
                    }
                }
                ans += cnt;
            }
        }

        bw.write(ans + "\n");
        bw.close();

    }
}
