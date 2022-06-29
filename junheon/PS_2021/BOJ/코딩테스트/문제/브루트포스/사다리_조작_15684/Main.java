package PS_2021.BOJ.코딩테스트.문제.브루트포스.사다리_조작_15684;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int V, H, M;
    static int[][] ladder;
    static int ans = -1;

    public static boolean check() {
        for (int k = 1; k <= V; k++) {
            int j = k;
            for (int i = 1; i <= H; i++) {
                if (ladder[i][j] != 0) j = ladder[i][j];
            }
            if (j != k) return false;
        }
        return true;
    }

    public static boolean solve(int max, int count, int x, int y) {
        if (max == count) {
            if (check()) {
                if (ans == -1 || ans > count) {
                    ans = count;
                    return true;
                }
            }
            return false;
        }
        for (int i = x; i <= H; i++) {
            int j;
            if (i == x) j = y;
            else j = 1;
            for (; j < V; j++) {
                if (ladder[i][j] == 0 && ladder[i][j + 1] == 0) {
                    ladder[i][j] = j + 1;
                    ladder[i][j + 1] = j;
                    if (solve(max, count + 1, i, j)) return true;
                    ladder[i][j] = ladder[i][j + 1] = 0;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladder = new int[H + 1][V + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladder[x][y] = y + 1;
            ladder[x][y + 1] = y;
        }

        for (int i = 0; i <= 3; i++) {
            if (solve(i, 0, 1, 1)) break;
        }
        System.out.println(ans);
    }
}
