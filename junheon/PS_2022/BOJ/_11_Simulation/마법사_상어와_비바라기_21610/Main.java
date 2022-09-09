package PS_2022.BOJ._11_Simulation.마법사_상어와_비바라기_21610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/21610
 * 알고리즘: 시뮬레이션
 * 시간복잡도: O(n^2), n=50(행,열)
 */

public class Main {

    static int n, m;
    static int[][] board;
    static boolean[][] cloud;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        cloud = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cloud[n - 1][0] = cloud[n - 2][0] = cloud[n - 1][1] = cloud[n - 2][1] = true;
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()) - 1;
            int cnt = Integer.parseInt(st.nextToken());
            moveCloud(dir, cnt);
            copyWater();
            makeCloud();
        }
        System.out.println(sumCloud());
    }

    static void moveCloud(int dir, int cnt) {
        boolean[][] tmp = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!cloud[i][j]) continue;
                int nx = i, ny = j;
                for(int k = 0; k < cnt; k++) {
                    nx += dx[dir];
                    ny += dy[dir];
                    if(nx < 0) nx = n - 1;
                    else if(nx >= n) nx = 0;
                    if(ny < 0) ny = n - 1;
                    else if(ny >= n) ny = 0;
                }
                tmp[nx][ny] = true;
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                cloud[i][j] = tmp[i][j];
                if(cloud[i][j]) board[i][j]++;
            }
        }
    }

    static void copyWater() {
        int[][] tmp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tmp[i][j] = board[i][j];
                if(!cloud[i][j]) continue;
                int cnt = 0;
                for(int k = 1; k < 8; k += 2) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(board[nx][ny] > 0) cnt++;
                }
                tmp[i][j] += cnt;
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = tmp[i][j];
            }
        }
    }

    static void makeCloud() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(cloud[i][j]) cloud[i][j] = false;
                else if(board[i][j] >= 2) {
                    cloud[i][j] = true;
                    board[i][j] -= 2;
                }
            }
        }
    }

    static int sumCloud() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += board[i][j];
            }
        }
        return sum;
    }
}
