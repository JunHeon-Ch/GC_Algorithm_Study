package PS_2022.BOJ.Bruth_Force.오목_2615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2615
 * 알고리즘: 완전탐색
 * 시간복잡도: O(n^2), n=19(행,열)
 */

public class Main {

    static int[][] board = new int[20][20];
    static boolean[][][] visit = new boolean[20][20][4];
    static int[] dx = {0, 1, 1, 1};
    static int[] dy = {1, 1, 0, -1};
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                if(board[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    if(visit[i][j][k]) continue;
                    res = 0;
                    solve(i, j, k, board[i][j]);
                    if (res == 5) {
                        System.out.println(board[i][j]);
                        if(k == 3) System.out.println((i + 4) + " " + (j - 4));
                        else System.out.println(i + " " + j);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    static void solve(int x, int y, int dir, int color) {
        if (x < 1 || x > 19 || y < 1 || y > 19) return;
        if (board[x][y] != color || visit[x][y][dir]) return;
        visit[x][y][dir] = true;
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        res++;
        solve(nx, ny, dir, color);
    }
}
