package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 게리맨더링2 {
    static int[][] map;
    static int total = 0;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }

        select(n);
        System.out.println(ans);
    }

    static void select(int n) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int d1 = 1; d1 < n; d1++) {
                    for (int d2 = 1; d2 < n; d2++) {
                        if (x + d1 + d2 >= n) continue;
                        if (y - d1 < 0 || y + d2 >= n) continue;
                        result(x, y, d1, d2, n);
                    }
                }
            }
        }
    }

    static void result(int x, int y, int d1, int d2, int n) {
        boolean[][] board = new boolean[n][n];

        // 경계선 세팅
        for (int i = 0; i <= d1; i++) {
            board[x + i][y - i] = true;
            board[x + d2 + i][y + d2 - i] = true;
        }

        for (int i = 0; i <= d2; i++) {
            board[x + i][y + i] = true;
            board[x + d1 + i][y - d1 + i] = true;
        }


        // 인구수
        int[] people = new int[5];

        // 1 구역 인구수
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (board[i][j]) break;
                people[0] += map[i][j];
            }
        }

        // 2 구역 인구수
        for (int i = 0; i <= x + d2; i++) {
            for (int j = n - 1; j > y; j--) {
                if (board[i][j]) break;
                people[1] += map[i][j];
            }
        }

        // 3 구역 인구수
        for (int i = x + d1; i < n; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (board[i][j]) break;
                people[2] += map[i][j];
            }
        }

        // 4 구역 인구수
        for (int i = x + d2 + 1; i < n; i++) {
            for (int j = n - 1; j >= y - d1 + d2; j--) {
                if (board[i][j]) break;
                people[3] += map[i][j];
            }
        }
        people[4] = total;
        for (int i = 0; i < 4; i++) {
            people[4] -= people[i];
        }

        Arrays.sort(people);

        ans = Math.min(ans, people[4] - people[0]);
    }


}
