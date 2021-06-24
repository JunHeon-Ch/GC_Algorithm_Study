import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _17837_새로운게임2 {
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
        int x, y, z;

        Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
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

    static void move(ArrayList<chess>[][] board, int x, int y, int z, int nx, int ny) {
        for (int i = z; i < board[x][y].size(); i++) {
            board[nx][ny].add(board[x][y].get(i));
            int nz = board[nx][ny].size() - 1;
            where[board[x][y].get(i).num] = new Pair(nx, ny, nz);
        }
        int len = board[x][y].size()-z;
        for (int i = 0; i < len; i++) {
            board[x][y].remove(z);
        }

    }

    static void reverse(ArrayList<chess>[][] board, int x, int y, int z, int nx, int ny) {
        for (int i = board[x][y].size() - 1; i >= z; i--) {
            board[nx][ny].add(board[x][y].get(i));
            int nz = board[nx][ny].size() - 1;
            where[board[x][y].get(i).num] = new Pair(nx, ny, nz);
        }
        int len = board[x][y].size()-z;
        for (int i = 0; i < len; i++) {
            board[x][y].remove(z);
        }
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
            where[i] = new Pair(x, y, 0);
        }

        for (int t = 1; t <= 1000; t++) {
            for (int i = 0; i < k; i++) {
                Pair p = where[i];
                chess c = board[p.x][p.y].get(p.z);

                int nx = p.x + dx[c.dir];
                int ny = p.y + dy[c.dir];

                if (nx >= n || nx < 0 || ny >= n || ny < 0 || map[nx][ny] == 2) {
                    c.dir = opposite(c.dir);
                }

                nx = p.x + dx[c.dir];
                ny = p.y + dy[c.dir];

                if (nx < n && nx >= 0 && ny < n && ny >= 0 && map[nx][ny] != 2) {
                    if (map[nx][ny] == 0) {
                        move(board, p.x, p.y, p.z, nx, ny);
                    } else if (map[nx][ny] == 1) {
                        reverse(board, p.x, p.y, p.z, nx, ny);
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

