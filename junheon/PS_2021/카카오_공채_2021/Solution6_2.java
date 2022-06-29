package PS_2021.카카오_공채_2021;

class Solution6_2 {

    public int solution(int[][] board, int[][] skill) {
        int ans = board.length * board[0].length;
        boolean[][] destroyed = new boolean[board.length][board[0].length];

        int MaxRow = board.length;
        int MaxCol = board[0].length;

        for (int i = 0; i < skill.length; i++) {
            int degree = skill[i][5];
            if (skill[i][0] == 1) {
                degree = -degree;
            }
            for (int r = skill[i][1]; r <= skill[i][3] && r < MaxRow; r++) {
                for (int c = skill[i][2]; c <= skill[i][4] && c < MaxCol; c++) {
                    board[r][c] += degree;
                    if (board[r][c] <= 0 && !destroyed[r][c]) {
                        destroyed[r][c] = true;
                        ans--;
                    } else if (destroyed[r][c] && board[r][c] > 0) {
                        destroyed[r][c] = false;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}