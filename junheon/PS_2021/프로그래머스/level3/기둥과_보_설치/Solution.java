package PS_2021.프로그래머스.level3.기둥과_보_설치;

/*
https://programmers.co.kr/learn/courses/30/lessons/60061
 * 알고리즘: 시뮬레이션
 * 시간복잡도: O(m*n^2), n=100(board 행의 길이), m=1,000(build_frame의 길이)
 */

class Solution {

    boolean[][] beam;
    boolean[][] column;

    public int[][] solution(int n, int[][] build_frame) {
        beam = new boolean[n + 1][n + 1]; // 보
        column = new boolean[n + 1][n + 1]; // 기둥
        int cnt = 0;
        for(int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int a = frame[2];
            int b = frame[3];
            if(b == 0) { // 삭제
                if(a == 0) { // 기둥
                    column[x][y] = false;
                    if(!isSafe(n)) column[x][y] = true;
                    else cnt--;
                } else if(a == 1) { // 보
                    beam[x][y] = false;
                    if(!isSafe(n)) beam[x][y] = true;
                    else cnt--;
                }
            } else if(b == 1) { // 설치
                if(a == 0) { // 기둥
                    column[x][y] = true;
                    if(!isSafe(n)) column[x][y] = false;
                    else cnt++;
                } else if(a == 1) { // 보
                    beam[x][y] = true;
                    if(!isSafe(n)) beam[x][y] = false;
                    else cnt++;
                }
            }
        }

        int[][] answer = new int[cnt][3];
        cnt = 0;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(column[i][j]) {
                    answer[cnt][0] = i;
                    answer[cnt][1] = j;
                    answer[cnt++][2] = 0;
                }
                if(beam[i][j]) {
                    answer[cnt][0] = i;
                    answer[cnt][1] = j;
                    answer[cnt++][2] = 1;
                }
            }
        }
        return answer;
    }

    public boolean isSafe(int n) {
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(beam[i][j]) {
                    // 보의 왼쪽 아래에 기둥이 있는 경우
                    if(j - 1 >= 0 && column[i][j - 1]) continue;
                    // 보의 오른쪽 아래에 기둥이 있는 경우
                    if(i + 1 <= n && j - 1 >= 0 && column[i + 1][j - 1]) continue;
                    // 보의 양쪽 끝에 보가 있는 경우
                    if((i - 1 >= 0 && beam[i - 1][j]) && (i + 1 <= n && beam[i + 1][j])) continue;
                    return false;
                }
                if(column[i][j]) {
                    // 바닥에 있는 경우
                    if(j == 0) continue;
                    // 다른 기둥 위에 있는 경우
                    if(j - 1 >= 0 && column[i][j - 1]) continue;
                    // 보의 한쪽 끝 부분 위에 있을 경우
                    if((i - 1 >= 0 && beam[i - 1][j]) || beam[i][j]) continue;
                    return false;
                }
            }
        }
        return true;
    }
}