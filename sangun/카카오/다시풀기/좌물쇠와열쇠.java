package 다시풀기;

public class 좌물쇠와열쇠 {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        int n = lock.length;
        int m = key.length;
        int[][] map = new int[2 * m + n - 2][2 * m + n - 2];

        for (int i = m - 1; i < m + n - 1; i++) {
            for (int j = m - 1; j < m + n - 1; j++) {
                map[i][j] = lock[i - m + 1][j - m + 1];
            }
        }

        for (int t = 0; t < 4; t++) {
            rotate(key);
            for (int i = 0; i < n + m - 1; i++) {
                for (int j = 0; j < n + m - 1; j++) {
                    plus(key, map, i, j);
                    if (valid(map, m, n)) System.out.println("success");
                    minus(key, map, i, j);
                }
            }

        }
    }

    static void rotate(int[][] key) {
        int n = key.length;

        int[][] rotate = new int[n][n];
        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = key[n - 1 - j][i];
            }
        }
        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate.length; j++) {
                key[i][j] = rotate[i][j];

            }

        }
    }

    static void plus(int[][] key, int[][] map, int x, int y) {
        for (int i = x; i < x + key.length; i++) {
            for (int j = y; j < y + key.length; j++) {
                map[i][j] += key[i - x][j - y];
            }
        }

    }

    static void minus(int[][] key, int[][] map, int x, int y) {
        for (int i = x; i < x + key.length; i++) {
            for (int j = y; j < y + key.length; j++) {
                map[i][j] -= key[i - x][j - y];
            }
        }
    }

    static boolean valid(int[][] map, int m, int n) {
        for (int i = m - 1; i < m + n - 1; i++) {
            for (int j = m - 1; j < m + n - 1; j++) {
                if (map[i][j] != 1) return false;
            }
        }
        return true;
    }

    static void print(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

}
