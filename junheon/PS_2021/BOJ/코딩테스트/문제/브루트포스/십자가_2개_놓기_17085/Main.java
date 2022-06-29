package PS_2021.BOJ.코딩테스트.문제.브루트포스.십자가_2개_놓기_17085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] board;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans = 0;

    public static void solve(int cnt, int res) {
        if (cnt == 2) {
            ans = Math.max(ans, res);
            return;
        }

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(visit[r][c] || board[r][c] == '.') continue;
                int size = 0;
                while(true) {
                    int i;
                    for (i = 0; i < 4; i++) {
                        int nr = r + dx[i] * size;
                        int nc = c + dy[i] * size;
                        if (nr < 0 || nr >= N || nc < 0 || nc >= M) break;
                        if(visit[nr][nc]) break;
                        if(board[nr][nc] != '#') break;
                    }
                    if (i == 4) {
                        for(int k = 0; k <= size; k++) {
                            for(int j = 0; j < 4; j++) {
                                int nr = r + dx[j] * k;
                                int nc = c + dy[j] * k;
                                visit[nr][nc] = true;
                            }
                        }
                        solve(cnt + 1, res * (1 + 4 * size));
                        size++;
                    } else {
                        for(int k = 0; k < size; k++) {
                            for(int j = 0; j < 4; j++) {
                                int nr = r + dx[j] * k;
                                int nc = c + dy[j] * k;
                                visit[nr][nc] = false;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            int j = 0;
            for (char c : br.readLine().toCharArray()) {
                board[i][j++] = c;
            }
        }
        solve(0, 1);
        System.out.println(ans);
    }
}
