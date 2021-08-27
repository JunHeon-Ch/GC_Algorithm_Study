package 프로그래머스.level2.행렬_테두리_회전하기;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows][columns];
        int cnt = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                board[i][j] = cnt++;
            }
        }

        int[] answer = new int[queries.length];
        for(int k = 0; k < queries.length; k++) {
            int x1 = queries[k][0] - 1;
            int y1 = queries[k][1] - 1;
            int x2 = queries[k][2] - 1;
            int y2 = queries[k][3] - 1;
            int prev = board[x1][y1];
            int next;
            int min = prev;
            for(int j = y1 + 1; j <= y2; j++) {
                min = Math.min(min, prev);
                next = board[x1][j];
                board[x1][j] = prev;
                prev = next;
            }
            for(int i = x1 + 1; i <= x2; i++) {
                min = Math.min(min, prev);
                next = board[i][y2];
                board[i][y2] = prev;
                prev = next;
            }
            for(int j = y2 - 1; j >= y1; j--) {
                min = Math.min(min, prev);
                next = board[x2][j];
                board[x2][j] = prev;
                prev = next;
            }
            for(int i = x2 - 1; i >= x1; i--) {
                min = Math.min(min, prev);
                next = board[i][y1];
                board[i][y1] = prev;
                prev = next;
            }
            answer[k] = min;

        }
        return answer;
    }
}