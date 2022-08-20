package PS_2022.BOJ.Simulation.미세먼지_안녕_17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/17144
 * 알고리즘: 시뮬레이션
 * 시간복잡도: O(n^2), n=50(행,열)
 */

public class Main {

    static int r, c;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        board = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (t-- > 0) {
            spread();
            cleanAir();
        }

        int ans = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i][j] != -1) ans += board[i][j];
            }
        }
        System.out.println(ans);
    }

    static void spread() {
        int[][] tmp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                tmp[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 0 || board[i][j] == -1) continue;
                int cnt = 0;
                int val = board[i][j] / 5;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                    if (board[nx][ny] == -1) continue;
                    cnt++;
                    tmp[nx][ny] += val;
                }
                tmp[i][j] -= (val * cnt);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = tmp[i][j];
            }
        }
    }

    static void cleanAir() {

        int x = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i][j] == -1) x = i;
            }
        }

        x--;
        int prev = 0;
        for(int j = 1; j < c; j++) {
            int tmp = board[x][j];
            board[x][j] = prev;
            prev = tmp;
        }
        for(int i = x - 1; i >= 0; i--) {
            int tmp = board[i][c - 1];
            board[i][c - 1] = prev;
            prev = tmp;
        }
        for(int j = c - 2; j >= 0; j--) {
            int tmp = board[0][j];
            board[0][j] = prev;
            prev = tmp;
        }
        for(int i = 1; i < x; i++) {
            int tmp = board[i][0];
            board[i][0] = prev;
            prev = tmp;
        }

        x++;
        prev = 0;
        for(int j = 1; j < c; j++) {
            int tmp = board[x][j];
            board[x][j] = prev;
            prev = tmp;
        }
        for(int i = x + 1; i < r; i++) {
            int tmp = board[i][c - 1];
            board[i][c - 1] = prev;
            prev = tmp;
        }
        for(int j = c - 2; j >= 0; j--) {
            int tmp = board[r - 1][j];
            board[r - 1][j] = prev;
            prev = tmp;
        }
        for(int i = r - 2; i > x; i--) {
            int tmp = board[i][0];
            board[i][0] = prev;
            prev = tmp;
        }
    }
}
