package algo_11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < m; i++) {
            map[0][i] += map[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            map[i][0] += map[i - 1][0];
        }



        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                map[i][j] += Math.max(Math.max(map[i - 1][j - 1], map[i - 1][j]), map[i][j - 1]);
            }
        }
        System.out.println(map[n - 1][m - 1]);

    }
}
