package 푼문제;

import java.util.ArrayList;
import java.util.Arrays;

public class 기둥과보설치 {
    public static void main(String[] args) {
        int n = 5;
        int[][] build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};

        boolean[][] col = new boolean[n + 1][n + 1];
        boolean[][] flo = new boolean[n + 1][n + 1];

        for (int[] f : build_frame) {
            int x = f[0];
            int y = f[1];
            int a = f[2];
            int b = f[3];

            if (b == 1) {
                //기둥
                if (a == 0) {
                    col[x][y] = true;
                    if (!valid(col, flo, n + 1)) col[x][y] = false;
                }
                if (a == 1) {
                    flo[x][y] = true;
                    if (!valid(col, flo, n + 1)) flo[x][y] = false;
                }
            } else {
                //기둥
                if (a == 0) {
                    col[x][y] = false;
                    if (!valid(col, flo, n + 1)) col[x][y] = true;
                }
                if (a == 1) {
                    flo[x][y] = false;
                    if (!valid(col, flo, n + 1)) flo[x][y] = true;
                }

            }
        }

        ArrayList<Pair> point = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (col[i][j]) point.add(new Pair(i, j, 0));
                if (flo[i][j]) point.add(new Pair(i, j, 1));
            }
        }
        int[][] answer = new int[point.size()][3];
        for (int i = 0; i < point.size(); i++) {
            answer[i][0] = point.get(i).x;
            answer[i][1] = point.get(i).y;
            answer[i][2] = point.get(i).v;
        }

        System.out.println(Arrays.deepToString(answer));
    }


    static boolean valid(boolean[][] col, boolean[][] flo, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (col[i][j]) {
                    if (!(j == 0 || col[i][j - 1] || flo[i][j] || (i > 0 && flo[i - 1][j]))) return false;
                }
                if (flo[i][j]) {
                    if (!((j > 0 && col[i][j - 1]) || col[i + 1][j - 1] || (i > 0 && flo[i - 1][j] && flo[i + 1][j])))
                        return false;
                }
            }
        }

        return true;
    }

    static class Pair {
        int x, y, v;

        public Pair(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
}