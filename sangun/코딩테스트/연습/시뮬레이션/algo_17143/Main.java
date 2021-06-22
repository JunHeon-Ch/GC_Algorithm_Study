package algo_17143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, m;
    // 0, 1, 2, 3, 4
    // 멈 상 하 우 좌
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Pair {
        int speed, dir, size;

        Pair(int speed, int dir, int size) {
            this.dir = dir;
            this.size = size;
            this.speed = speed;
        }

        public Pair(Pair pair) {
            this.size = pair.size;
            this.dir = pair.dir;
            this.speed = pair.speed;
        }
    }

    static class Tuple {
        int x, y, d;

        Tuple(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static Pair[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new Pair[r][c];
        Pair[][] copy = new Pair[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = new Pair(0, 0, 0);
                copy[i][j] = new Pair(0, 0, 0);
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken());
            if (d <= 1) {
                s %= (2 * r - 2);
            } else {
                s %= (2 * c - 2);
            }

            map[a - 1][b - 1] = new Pair(s, d, e);
        }

        long ans = 0;

        for (int t = 0; t < c; t++) {

            for (int i = 0; i < r; i++) {
                if (map[i][t].size != 0) {
                    ans += map[i][t].size;
                    map[i][t].size = 0;
                    break;
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j].size != 0) {
                        Tuple temp = move(map[i][j], i, j);
                        if (copy[temp.x][temp.y].size < map[i][j].size || copy[temp.x][temp.y].size == 0) {
                            copy[temp.x][temp.y] = new Pair(map[i][j].speed, temp.d, map[i][j].size);
                        }
                    }
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    map[i][j] = new Pair(copy[i][j]);
                    copy[i][j].size = 0;
                }
            }

        }
        System.out.println(ans);

    }

    static Tuple move(Pair shark, int x, int y) {
        for (int i = 0; i < shark.speed; i++) {
            if (shark.dir == 0) {
                if (x == 0) {
                    x = 1;
                    shark.dir = 1;
                } else x--;
            } else if (shark.dir == 1) {
                if (x == r - 1) {
                    x = r - 2;
                    shark.dir = 0;
                } else x++;
            } else if (shark.dir == 2) {
                if (y == c - 1) {
                    y = c - 2;
                    shark.dir = 3;
                } else y++;
            } else if (shark.dir == 3) {
                if (y == 0) {
                    y = 1;
                    shark.dir = 2;
                } else y--;
            } else {
                break;
            }
        }
        return new Tuple(x, y, shark.dir);
    }
}
