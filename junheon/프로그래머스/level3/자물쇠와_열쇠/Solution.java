package 프로그래머스.level3.자물쇠와_열쇠;

/*
https://programmers.co.kr/learn/courses/30/lessons/60059
 * 알고리즘: 구현
 * 시간복잡도: ((n+m)^2)*(4*m^2) = O(n^2*m^2),
 * n=20(lock 배열의 크기), m=20(key 배열의 크기), n이 항상 m보다 크거나 같음
 */

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        // lock의 홈이 있는 위치
        int minX = n + m, minY = n + m, maxX = -1, maxY = -1;
        // 상하좌우 key의 크기를 추가한 배열 생성
        int[][] board = new int[n + 2 * m][n + 2 * m];
        for (int i = m; i < n + m; i++) {
            for (int j = m; j < n + m; j++) {
                board[i][j] = lock[i - m][j - m];
                if (board[i][j] == 0) {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        // 0 -> original / 1 -> 90 / 2 -> 180 / 3 -> 270
        int[][][] keys = new int[m][m][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                keys[i][j][0] = key[i][j];
            }
        }
        for (int k = 1; k < 4; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    keys[j][m - 1 - i][k] = keys[i][j][k - 1];
                }
            }
        }

        // (n+m)^2
        for (int i = 1; i < board.length - m; i++) {
            for (int j = 1; j < board[i].length - m; j++) {
                // lock의 홈들의 위치를 벗어난 경우
                if (i > minX || i + m - 1 < maxX || j > minY || j + m - 1 < maxY) continue;
                // 4*(m^2)
                for (int k = 0; k < 4; k++) {
                    boolean unlock = true;
                    // key의 위치 (a, b) ~ (a+m-1, b+m-1)
                    for (int a = i; a < i + m; a++) {
                        for (int b = j; b < j + m; b++) {
                            // key의 위치가 lock의 위치를 벗어난 경우 고려할 필요 없음
                            if (a < m || a >= n + m || b < m || b >= n + m) continue;
                            // (a, b) 위치에 (lock의 홈, key의 홈) or (lock의 돌기, key의 돌기)가 위치한 경우
                            if ((board[a][b] == keys[a - i][b - j][k])) {
                                unlock = false;
                                break;
                            }
                        }
                    }
                    if (unlock) return true;
                }
            }
        }
        return false;
    }
}