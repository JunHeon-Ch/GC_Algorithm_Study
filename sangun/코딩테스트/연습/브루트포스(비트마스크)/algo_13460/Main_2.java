package algo_13460;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2 {

    private static char[][] map;
    private static int n, m;
    private static int count = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new char[n][m];

        dot red = null, blue = null;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (str.charAt(j) == 'R')
                    red = new dot(i, j, 0);
                if (str.charAt(j) == 'B')
                    blue = new dot(i, j, 0);
            }
        }

        bfs(red, blue);

        bw.write(count + "\n");
        bw.flush();

    }

    public static void bfs(dot red, dot blue) {
        Queue<dot> red_queue = new LinkedList<>();
        Queue<dot> blue_queue = new LinkedList<>();
        boolean redflag = false;
        boolean blueflag = false;

        red_queue.add(red);
        blue_queue.add(blue);

        while (!red_queue.isEmpty() && !blue_queue.isEmpty()) {

            dot p1 = red_queue.poll();
            dot p2 = blue_queue.poll();

            if (p1.count < 10) {

                // 상,하,좌,우 4가지 경우
                for (int i = 0; i < 4; i++) {

                    dot r = new dot(p1.x, p1.y, p1.count);
                    dot b = new dot(p2.x, p2.y, p2.count);
                    map[r.x][r.y] = 'R';
                    map[b.x][b.y] = 'B';

                    redflag = false;
                    blueflag = false;

                    // 한번 기울이면 장애물을 만날때까지는 계속 이동하므로 while문을 사용
                    while (true) {
                        if (map[r.x + dx[i]][r.y + dy[i]] == 'O') {
                            redflag = true;
                            map[r.x][r.y] = '.';
                            r.x = r.x + dx[i];
                            r.y = r.y + dy[i];
                        }

                        // 파란구슬이 구멍에 빠지면 기우는 것을 멈춤
                        if (map[b.x + dx[i]][b.y + dy[i]] == 'O') {
                            blueflag = true;
                            break;
                        }
                        // 빨간구슬, 파란구슬 둘 다 움직일 수 없는 경우 멈춤
                        // 파란구슬이 장애물(벽,빨간구슬)에 막히고, 빨간구슬도 장애물에 막히거나 빨간구슬이 구멍이 빠진 경우
                        if ((map[r.x + dx[i]][r.y + dy[i]] != '.' || redflag)
                                && map[b.x + dx[i]][b.y + dy[i]] != '.')
                            break;

                        if (map[r.x + dx[i]][r.y + dy[i]] == '.' && !redflag) {
                            map[r.x][r.y] = '.';
                            r.x = r.x + dx[i];
                            r.y = r.y + dy[i];
                            map[r.x][r.y] = 'R';
                        }
                        if (map[b.x + dx[i]][b.y + dy[i]] == '.') {
                            map[b.x][b.y] = '.';
                            b.x = b.x + dx[i];
                            b.y = b.y + dy[i];
                            map[b.x][b.y] = 'B';
                        }
                    }

                    if (redflag && !blueflag) {
                        count = p1.count + 1;
                        return;
                    }

                    if (blueflag)
                        count = -1;
                    else {
                        red_queue.add(new dot(r.x, r.y, p1.count + 1));
                        blue_queue.add(new dot(b.x, b.y, p2.count + 1));
                    }

                    if (map[r.x][r.y] == 'R')
                        map[r.x][r.y] = '.';
                    if (map[b.x][b.y] == 'B')
                        map[b.x][b.y] = '.';
                }
            } else
                count = -1;
        }
    }
}

class dot {

    int x, y, count;

    dot(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}