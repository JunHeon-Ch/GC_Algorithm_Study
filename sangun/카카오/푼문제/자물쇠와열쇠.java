package 푼문제;

public class 자물쇠와열쇠 {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        int n = lock.length;
        int m = key.length;

        int[][] map = new int[m * 2 + n][m * 2 + n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[m + i][m + j] = lock[i][j];
            }
        }

        for (int t = 0; t < 4; t++) {
            key = rotate(key);
            for (int i = 1; i < n + m; i++) {
                for (int j = 1; j < n + m; j++) {
                    plus(map, key, i, j, m);
                    if (valid(map, n, m)) System.out.println("true");
                    minus(map, key, i, j, m);
                }
            }
        }


    }

    static int[][] rotate(int[][] key) {
        int n = key.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n - i - 1] = key[i][j];
            }
        }
        return result;
    }

    static boolean valid(int[][] map, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[m + i][m + j] != 1) return false;
            }
        }
        return true;
    }

    static void plus(int[][] map, int[][] key, int x, int y, int m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                map[x + i][y + j] += key[i][j];
            }
        }
    }

    static void minus(int[][] map, int[][] key, int x, int y, int m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                map[x + i][y + j] -= key[i][j];
            }
        }
    }
}
