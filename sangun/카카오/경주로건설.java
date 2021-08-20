import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};
//        int[][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
//        int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
        System.out.println(bfs(board, board.length, board[0].length));


    }

    // 직선 100원
    // 코너 500원
    static int bfs(int[][] board, int n, int m) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, -1, 0));
        int[][] expense = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(expense[i], Integer.MAX_VALUE);
        }


        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Pair p = q.remove();

            if (p.x == n - 1 && p.y == m - 1) {
                ans = Math.min(ans, expense[p.x][p.y]);
            }
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];


                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == 1) continue;
                int pay = 0;

                if (p.d == -1 || p.d == i) pay = p.c + 100;
                else pay = p.c + 600;

                if (pay <= expense[nx][ny]) {
                    expense[nx][ny] = pay;
                    q.add(new Pair(nx, ny, i, pay));
                }


            }
        }
        return ans;
    }

    static class Pair {
        int x, y, d, c;

        public Pair(int x, int y, int d, int c) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.c = c;
        }
    }
}
