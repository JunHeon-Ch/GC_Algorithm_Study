package PS_2021.BOJ.코딩테스트.문제.브루트포스.색종이_붙이기_17136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] board = new boolean[10][10];
    static int[] paper = {5, 5, 5, 5, 5};
    static int total = 0, ans = -1;

    public static void solve(int cnt, int now, int x) {
        if (now == total) {
            if (ans == -1 || ans > cnt) ans = cnt;
            return;
        }
        for (int i = x; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // 색종이 사이즈
                if(!board[i][j]) continue;
                for(int k = 5; k > 0; k--) {
                    boolean flag = false;
                    if (paper[k - 1] > 0 && i + k <= 10 && j + k <= 10) {
                        for (int r = i; r < i + k; r++) {
                            for (int c = j; c < j + k; c++) {
                                if (!board[r][c]) {
                                    flag = true;
                                    break;
                                }
                            }
                            if(flag) break;
                        }
                        if (!flag) {
                            for (int r = i; r < i + k; r++) {
                                for (int c = j; c < j + k; c++) {
                                    board[r][c] = false;
                                }
                            }
                            paper[k - 1]--;
                            solve(cnt + 1, now + k * k, i);
                            paper[k - 1]++;
                            for (int r = i; r < i + k; r++) {
                                for (int c = j; c < j + k; c++) {
                                    board[r][c] = true;
                                }
                            }
                        }
                    }
                }
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                if (st.nextToken().equals("1")) {
                    board[i][j] = true;
                    total++;
                }
            }
        }
        solve(0, 0, 0);
        System.out.println(ans);
    }
}
