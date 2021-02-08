package algo_1917;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map = new int[6][6];
    static boolean type2 = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 0; t < 3; t++) {

            for (int i = 0; i < 6; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 6; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean check = false;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] == 1) {
                        for (int k = 0; k < 4; k++) {
                            if (dfs(i, j, k, 1)) {
                                if (type1(k, i, j, 4)) {
                                    bw.write("yes\n");
                                    check = true;
                                    break;
                                }
                            } else if (dfs(i, j, k, 2)) {
                                if (type1(k, i, j, 3)) {
                                    if (type2) {
                                        bw.write("yes\n");
                                        check = true;
                                        break;
                                    }
                                }
                                int nx = i + 2 * dx[k] + dx[(k + 1) % 4];
                                int ny = j + 2 * dy[k] + dy[(k + 1) % 4];
                                if (nx < 6 && nx >= 0 && ny < 6 && ny >= 0) {
                                    if (map[nx][ny] == 1) {
                                        if (dfs(nx, ny, k, 2)) {
                                            bw.write("yes\n");
                                            check = true;
                                            break;
                                        }
                                    }
                                }
                                int tx = i + 2 * dx[k] + dx[(k + 3) % 4];
                                int ty = j + 2 * dy[k] + dy[(k + 3) % 4];
                                if (tx < 6 && tx >= 0 && ty < 6 && ty >= 0) {
                                    if (map[tx][ty] == 1) {
                                        if (dfs(tx, ty, k, 2)) {
                                            bw.write("yes\n");
                                            check = true;
                                            break;
                                        }
                                    }
                                }
                            } else if (dfs(i, j, k, 3)) {
                                int nx = i + dx[k] + dx[(k + 3) % 4];
                                int ny = j + dy[k] + dx[(k + 3) % 4];
                                if (nx < 6 && nx >= 0 && ny < 6 && ny >= 0) {
                                    if (map[nx][ny] == 1) {

                                    }
                                }

                            }
                        }
                    }
                    if (check) break;
                }
                if (check) break;
            }

        }
        bw.close();

    }

    static boolean dfs(int x, int y, int dir, int cnt) {
        if (cnt == 4) return true;
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx >= 6 || nx < 0 || ny >= 6 || ny < 0) return false;
        if (map[nx][ny] == 1) {
            if (dfs(nx, ny, dir, cnt + 1)) return true;
            else return false;
        } else return false;
    }

    static boolean type1(int dir, int x, int y, int cnt) {
        int rcnt = 0;
        int lcnt = 0;
        int left = (dir + 1) % 4;
        int right = (dir + 3) % 4;
        for (int i = 0; i < cnt; i++) {
            int nx = x + i * dx[dir] + dx[left];
            int ny = y + i * dy[dir] + dy[left];
            if (nx < 6 && nx >= 0 && ny < 6 && ny >= 0) {
                if (map[nx][ny] == 1) {
                    lcnt++;
                    int tempx = nx + dx[(dir + 2) % 4];
                    int tempy = ny + dy[(dir + 2) % 4];
                    if (tempx < 6 && tempx >= 0 && tempy < 6 && tempy >= 0) {
                        if (map[tempx][tempy] == 1) {
                            type2 = true;
                        }
                    }
                }
            }
            nx = x + i * dx[dir] + dx[right];
            ny = y + i * dy[dir] + dy[right];
            if (nx < 6 && nx >= 0 && ny < 6 && ny >= 0) {
                if (map[nx][ny] == 1) {
                    rcnt++;
                    int tempx = nx + dx[(dir + 2) % 4];
                    int tempy = ny + dy[(dir + 2) % 4];
                    if (tempx < 6 && tempx >= 0 && tempy < 6 && tempy >= 0) {
                        if (map[tempx][tempy] == 1) {
                            type2 = true;
                        }
                    }
                }
            }
        }
        if (rcnt == 1 && lcnt == 1) {
            return true;
        } else return false;

    }

}
