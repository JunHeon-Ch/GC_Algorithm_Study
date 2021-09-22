package 다시풀기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        int[] answer = new int[2];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0&&!visited[i][j]) {
                    answer[1] = Math.max(answer[1], bfs(picture, visited, i, j, picture[i][j]));
                    answer[0]++;
                }

            }
        }
        System.out.println(Arrays.toString(answer));
    }

    static int bfs(int[][] map, boolean[][] visited, int x, int y, int color) {
        int n = map.length;
        int m = map[0].length;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visited[x][y] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            Pair p = queue.remove();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] != color) continue;

                visited[nx][ny] = true;
                cnt++;
                queue.add(new Pair(nx, ny));
            }
        }

        return cnt;

    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
