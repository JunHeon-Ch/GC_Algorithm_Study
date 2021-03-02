package algo_16933;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int[][] map;
    static boolean[][][] visit;
    static int ans = -1;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    static class dot {
        int x, y, d, b;

        dot(int x, int y, int d, int b) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        bfs();
        bw.write(ans + "\n");
        bw.close();


    }

    static void bfs() {
        Queue<dot> q = new LinkedList<>();
        q.offer(new dot(0, 0, 1, 0));
        boolean time = true;
        visit[0][0][0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int t = 0; t < size; t++) {
                dot temp = q.poll();
                if (temp.x == n - 1 && temp.y == m - 1) {
                    ans = temp.d;
                    return;
                }
                boolean block = false;
                for (int i = 0; i < 4; i++) {
                    int nx = temp.x + dx[i];
                    int ny = temp.y + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                    if (map[nx][ny] == 0) { // 지나가는 거 가능
                        if (visit[nx][ny][temp.b]) continue;
                        visit[nx][ny][temp.b] = true;
                        q.offer(new dot(nx, ny, temp.d + 1, temp.b));
                    } else {
                        if (temp.b >= k) continue;
                        if (visit[nx][ny][temp.b + 1]) continue;
                        if (time) {
                            q.offer(new dot(nx, ny, temp.d + 1, temp.b + 1));
                            visit[nx][ny][temp.b + 1] = true;
                        } else {
                            block = true;
                        }
                    }
                }
                if (block) {
                    q.offer(new dot(temp.x, temp.y, temp.d + 1, temp.b));
                }
            }
            time = !time;
        }
    }
}

