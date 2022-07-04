package PS_2022.Programmers.level2.행렬_테두리_회전하기;

/*
https://programmers.co.kr/learn/courses/30/lessons/77485
 * 알고리즘: 구현
 * 시간복잡도: O(m*r*c), m=10,000(회전의 개수), r=100(행), c=100(열)
 */
class Solution {
    public int[] solution(int r, int c, int[][] q) {
        int[][] board = new int[r + 1][c + 1];
        int cnt = 0;
        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= c; j++) {
                board[i][j] = ++cnt;
            }
        }
        int[] ans = new int[q.length];
        for(int k = 0; k < q.length; k++) {
            int r1 = q[k][0];
            int c1 = q[k][1];
            int r2 = q[k][2];
            int c2 = q[k][3];
            int res = Integer.MAX_VALUE;
            int prev = board[r1][c1];
            for(int j = c1 + 1; j <= c2; j++) {
                res = Math.min(res, prev);
                int tmp = board[r1][j];
                board[r1][j] = prev;
                prev = tmp;
            }
            for(int i = r1 + 1; i <= r2; i++) {
                res = Math.min(res, prev);
                int tmp = board[i][c2];
                board[i][c2] = prev;
                prev = tmp;
            }
            for(int j = c2 - 1; j >= c1; j--) {
                res = Math.min(res, prev);
                int tmp = board[r2][j];
                board[r2][j] = prev;
                prev = tmp;
            }
            for(int i = r2 - 1; i >= r1; i--) {
                res = Math.min(res, prev);
                int tmp = board[i][c1];
                board[i][c1] = prev;
                prev = tmp;
            }
            ans[k] = res;
        }
        return ans;
    }
}