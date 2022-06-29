package PS_2021.프로그래머스.level3.리틀_프렌즈_사천성;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/1836
* 알고리즘: 구현
 */

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, 3, new String[]{"DBA", "C*A", "CDB"}));
    }
}
class Solution {

    public String solution(int n, int m, String[] board) {
        char[][] b = new char[n][m];
        for(int i = 0; i < n; i++) {
            b[i] = board[i].toCharArray();
        }

        List<Tile> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(b[i][j] >= 'A' && b[i][j] <= 'Z') {
                    list.add(new Tile(i, j, b[i][j]));
                }
            }
        }
        // 알파벳 순
        // 알파벳이 같으면 좌표상 왼쪽 순
        Collections.sort(list, (t1, t2) -> {
            if(t1.c == t2.c) {
                if(t1.y == t2.y) return t1.x - t2.x;
                return t1.y - t2.y;
            }
            return t1.c - t2.c;
        });

        StringBuilder sb = new StringBuilder();
        int i;
        for(i = 0; i < list.size(); i += 2) {
            Tile t1 = list.get(i);
            Tile t2 = list.get(i + 1);
            if(canRemove(t1, t2, b)) {
                sb.append(t1.c);
                list.remove(t1);
                list.remove(t2);
                b[t1.x][t1.y] = '.';
                b[t2.x][t2.y] = '.';
                i = -2;
            }
        }
        return i == 0 ? sb.toString() : "IMPOSSIBLE";
    }

    public boolean canRemove(Tile t1, Tile t2, char[][] b) {
        if(t1.x == t2.x) { // 가로
            for(int j = t1.y + 1; j < t2.y; j++) {
                if(b[t1.x][j] != '.') return false;
            }
            return true;
        } else if(t1.y == t2.y) { // 세로
            for(int i = t1.x + 1; i < t2.x; i++) {
                if(b[i][t1.y] != '.') return false;
            }
            return true;
        } else {
            boolean flag1 = true;
            boolean flag2 = true;
            if(t1.x > t2.x) {
                // 위 -> 우
                for(int i = t1.x - 1; i >= t2.x; i--) {
                    if(b[i][t1.y] != '.') {
                        flag1 = false;
                        break;
                    }
                }
                for(int j = t1.y + 1; j < t2.y; j++) {
                    if(b[t2.x][j] != '.') {
                        flag1 = false;
                        break;
                    }
                }
                // 우 -> 위
                for(int j = t1.y + 1; j <= t2.y; j++) {
                    if(b[t1.x][j] != '.') {
                        flag2 = false;
                        break;
                    }
                }
                for(int i = t1.x - 1; i > t2.x; i--) {
                    if(b[i][t2.y] != '.') {
                        flag2 = false;
                        break;
                    }
                }
            } else {
                // 하 -> 우
                for(int i = t1.x + 1; i <= t2.x; i++) {
                    if(b[i][t1.y] != '.') {
                        flag1 = false;
                        break;
                    }
                }
                for(int j = t1.y + 1; j < t2.y; j++) {
                    if(b[t2.x][j] != '.') {
                        flag1 = false;
                        break;
                    }
                }
                // 우 -> 하
                for(int j = t1.y + 1; j <= t2.y; j++) {
                    if(b[t1.x][j] != '.') {
                        flag2 = false;
                        break;
                    }
                }
                for(int i = t1.x + 1; i < t2.x; i++) {
                    if(b[i][t2.y] != '.') {
                        flag2 = false;
                        break;
                    }
                }
            }
            return flag1 || flag2;
        }
    }
}

class Tile {
    int x, y;
    char c;

    public Tile(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }
}