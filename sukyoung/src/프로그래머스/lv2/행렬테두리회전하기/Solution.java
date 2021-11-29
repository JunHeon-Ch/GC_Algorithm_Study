package 프로그래머스.lv2.행렬테두리회전하기;

class Solution {
    public int[][] table;
    public int[] solution(int rows, int columns, int[][] queries) {
        table = new int[rows][columns];
        for(int i=0; i < rows; i++){
            for(int j=0; j<columns; j++){
                table[i][j] = i * columns + j + 1;
            }
        }
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            answer[i] = rotate(queries[i]);
        }

        return answer;
    }
    public int rotate(int[] query){
        int r1 = query[0] - 1;
        int c1 = query[1] - 1;
        int r2 = query[2] - 1;
        int c2 = query[3] - 1;

        int start = table[r1][c1];
        int min = start;
        for(int i=r1; i<r2; i++){
            table[i][c1] = table[i+1][c1];
            min = Math.min(min, table[i][c1]);
        }
        for(int i = c1; i < c2; i++){
            table[r2][i] = table[r2][i+1];
            min = Math.min(min, table[r2][i]);
        }
        for(int i = r2; i > r1; i--){
            table[i][c2] = table[i-1][c2];
            min = Math.min(min, table[i][c2]);
        }
        for(int i = c2; i > c1; i--){
            table[r1][i] = table[r1][i-1];
            min = Math.min(min, table[r1][i]);
        }
        table[r1][c1+1] = start;

        return min;
    }
}