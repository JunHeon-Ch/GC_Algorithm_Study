import java.util.LinkedList;
import java.util.Queue;

public class _카카오프렌컬러링북 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        visited = new boolean[m][n];
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j]==0)continue;
                if (!visited[i][j]) {
                    max = Math.max(bfs(i, j, m, n, picture), max);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);


    }

    static int bfs(int x, int y, int m, int n, int[][] picture) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));

        visited[x][y] = true;
        int cnt = 1;
        int s = picture[x][y];
        while (!q.isEmpty()) {
            Pair p = q.remove();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= m || nx < 0 || ny >= n || ny < 0) continue;
                if (visited[nx][ny]) continue;
                if (picture[nx][ny] == s) {
                    cnt++;
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return cnt;
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
