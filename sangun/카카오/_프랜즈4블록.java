import java.util.ArrayList;

public class _프랜즈4블록 {
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    static boolean[][] delete;

    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        int answer = 0;
        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }


        boolean check = true;

        while (check) {
            delete = new boolean[m][n];
            check = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] == ' ') continue;
                    if (valid(map, i, j)) {
                        check = true;
                    }
                }
            }

            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (delete[x][y]){
                        map[x][y] = ' ';
                        System.out.println(x + " " + y);
                        answer++;
                    }
                }
            }
            System.out.println();

            move(map, m, n);

        }
        System.out.println(answer);
    }

    static boolean valid(char[][] board, int px, int py) {
        for (int k = 0; k < 3; k++) {
            int x = px + dx[k];
            int y = py + dy[k];
            if (board[px][py] != board[x][y]) return false;
        }
        for (int k = 0; k < 3; k++) {
            int x = px + dx[k];
            int y = py + dy[k];
            delete[x][y] = true;
        }
        delete[px][py] = true;

        return true;
    }

    static void move(char[][] board, int m, int n) {
        ArrayList<Character> arr = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if (board[i][j] != ' ') arr.add(board[i][j]);
            }
            for (int i = m - 1; i >= 0; i--) {
                if (arr.isEmpty()) board[i][j] = ' ';
                else board[i][j] = arr.remove(0);
            }
        }

    }

}
