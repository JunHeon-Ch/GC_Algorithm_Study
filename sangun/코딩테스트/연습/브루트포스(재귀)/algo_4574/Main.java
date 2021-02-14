package algo_4574;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] domino;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean end = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            cnt++;
            bw.write("Puzzle " + cnt + "\n");
            map = new int[9][9];
            domino = new boolean[10][10];
            end = false;
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j <= i; j++) {
                    domino[i][j] = true;
                }
            }
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                String ul = st.nextToken();
                int row = ul.charAt(0) - 'A';
                int col = ul.charAt(1) - '1';
                map[row][col] = u;
                int v = Integer.parseInt(st.nextToken());
                String vl = st.nextToken();
                row = vl.charAt(0) - 'A';
                col = vl.charAt(1) - '1';
                map[row][col] = v;
                domino[u][v] = true;
                domino[v][u] = true;

            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < 10; i++) {
                String ul = st.nextToken();
                int row = ul.charAt(0) - 'A';
                int col = ul.charAt(1) - '1';
                map[row][col] = i;
            }


            sudoku(0, 0);

        }
        bw.close();
    }

    static void sudoku(int row, int col) throws IOException {
        if (end) return;
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        if (row == 9) {

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(map[i][j]+"");
                }
                bw.write("\n");
            }
            end = true;
            return;
        }
        if (map[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(row, col, i)) {
                    // 상하좌우 탐색
                    for (int j = 0; j < 4; j++) {
                        int x = row + dx[j];
                        int y = col + dy[j];
                        if (x < 0 || x >= 9 || y < 0 || y >= 9) continue;
                        if (map[x][y] != 0) continue;
                        // 이동 위치의 가능한 값 찾기
                        for (int k = 1; k <= 9; k++) {
                            // 그 값이 사용됐었는지 확인
                            if (!(domino[i][k] && domino[k][i])) {
                                if (possibility(x, y, k)) {
                                    map[row][col] = i;
                                    map[x][y] = k;
                                    domino[i][k] = true;
                                    domino[k][i] = true;
                                    sudoku(row, col + 1);
                                    if (end) return;
                                    map[row][col] = 0;
                                    map[x][y] = 0;
                                    domino[i][k] = false;
                                    domino[k][i] = false;
                                }
                            }
                        }
                    }
                }
            }
            return;
        }
        sudoku(row, col + 1);

    }

    static boolean possibility(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == value) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (map[i][col] == value) return false;
        }

        int set_col = (col / 3) * 3;
        int set_row = (row / 3) * 3;
        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (map[i][j] == value) return false;
            }
        }

        return true;

    }
}
