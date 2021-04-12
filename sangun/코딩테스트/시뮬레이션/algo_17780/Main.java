package algo_17780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, k;

    static int[][] map;

    static class chess {
        int dir, num;

        chess(int dir, int num) {
            this.dir = dir;
            this.num = num;
        }

    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Pair[] where;

    static int opposite(int dir) {
        if (dir == 0) return 1;
        if (dir == 1) return 0;
        if (dir == 2) return 3;
        return 2;
    }

    static void move(ArrayList<chess>[][] board, int x, int y, int nx, int ny) {
        for (chess k : board[x][y]) {
            board[nx][ny].add(k);
            where[k.num] = new Pair(nx, ny);
        }
        board[x][y].clear();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        // 0 = white, 1 = red, 2 = blue
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<chess>[][] board = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = new ArrayList<>();
            }
        }

        where = new Pair[k];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            board[x][y].add(new chess(d, i));
            where[i] = new Pair(x, y);
        }

        for (int t = 1; t <= 1000; t++) {
            for (int i = 0; i < k; i++) {
                Pair p = where[i];
                if (board[p.x][p.y].get(0).num != i) continue;
                chess c = board[p.x][p.y].get(0);

                int nx = p.x + dx[c.dir];
                int ny = p.y + dy[c.dir];

                if (nx >= n || nx < 0 || ny >= n || ny < 0 || map[nx][ny] == 2) {
                    c.dir = opposite(c.dir);
                }

                nx = p.x + dx[c.dir];
                ny = p.y + dy[c.dir];

                if (nx < n && nx >= 0 && ny < n && ny >= 0 && map[nx][ny] != 2) {
                    if (map[nx][ny] == 0) {
                        move(board, p.x, p.y, nx, ny);
                    } else if (map[nx][ny] == 1) {
                        Collections.reverse(board[p.x][p.y]);
                        move(board, p.x, p.y, nx, ny);
                    }
                    if (board[nx][ny].size() >= 4) {
                        System.out.println(t);
                        System.exit(0);
                    }
                }


            }
        }
        System.out.println(-1);


    }
}
