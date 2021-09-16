package 시험;

import java.util.Arrays;

public class 문제6 {
    public static void main(String[] args) {
        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};


        for (int[] sk : skill) {
            int type = sk[0];
            int r1 = sk[1];
            int c1 = sk[2];
            int r2 = sk[3];
            int c2 = sk[4];
            int degree = sk[5];

            // 공격
            if (type == 1) {
                attack(board, r1, c1, r2, c2, degree);
            }
            // 회복
            else {
                recovery(board, r1, c1, r2, c2, degree);
            }
        }

        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 0)
                    answer++;
            }
        }
        System.out.println(Arrays.deepToString(board));
        System.out.println(answer);
    }

    static void attack(int[][] board, int r1, int c1, int r2, int c2, int degree) {
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                board[i][j] -= degree;
            }
        }
    }

    static void recovery(int[][] board, int r1, int c1, int r2, int c2, int degree) {
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                board[i][j] += degree;
            }
        }
    }

}
