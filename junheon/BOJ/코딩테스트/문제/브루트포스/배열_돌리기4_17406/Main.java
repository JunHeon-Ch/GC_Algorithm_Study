package BOJ.코딩테스트.문제.브루트포스.배열_돌리기4_17406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[][] board;
    static int[] r, c, s;
    static int[] seq;
    static boolean[] visit;
    static int ans = -1;

    public static int calc() {
        int[][] b = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                b[i][j] = board[i][j];
            }
        }
        for (int t = 0; t < K; t++) {

            int index = seq[t];
            int r1 = r[index] - s[index];
            int r2 = r[index] + s[index];
            int c1 = c[index] - s[index];
            int c2 = c[index] + s[index];
            while (r1 < r2 && c1 < c2) {
                int prev = b[r1][c1], next = prev;
                for (int j = c1; j < c2; j++) {
                    next = b[r1][j + 1];
                    b[r1][j + 1] = prev;
                    prev = next;
                }
                for (int i = r1; i < r2; i++) {
                    next = b[i + 1][c2];
                    b[i + 1][c2] = prev;
                    prev = next;
                }
                for (int j = c2; j > c1; j--) {
                    next = b[r2][j - 1];
                    b[r2][j - 1] = prev;
                    prev = next;
                }
                for (int i = r2; i > r1; i--) {
                    next = b[i - 1][c1];
                    b[i - 1][c1] = prev;
                    prev = next;
                }
                r1++;
                c1++;
                r2--;
                c2--;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += b[i][j];
            }
            res = Math.min(res, sum);
        }
        return res;
    }

    public static void solve(int index) {
        if (index == K) {
            int res = calc();
            if (ans == -1 || ans > res) ans = res;
            return;
        }
        for (int i = 0; i < K; i++) {
            if (!visit[i]) {
                visit[i] = true;
                seq[index] = i;
                solve(index + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        r = new int[K];
        c = new int[K];
        s = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken()) - 1;
            c[i] = Integer.parseInt(st.nextToken()) - 1;
            s[i] = Integer.parseInt(st.nextToken());
        }

        seq = new int[K];
        visit = new boolean[K];
        solve(0);
        System.out.println(ans);
    }
}
