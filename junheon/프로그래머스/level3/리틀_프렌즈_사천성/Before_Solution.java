//package 프로그래머스.level3.리틀_프렌즈_사천성;
//
//import java.nio.charset.CharacterCodingException;
//import java.util.*;
//
//class Solution {
//    public String solution(int n, int m, String[] b) {
//        // board -> 타일이 삭제되는 board
//        char[][] board = new char[n][m];
//        // origin -> 원본
//        char[][] origin = new char[n][m];
//        for(int i = 0; i < n; i++) {
//            board[i] = b[i].toCharArray();
//            origin[i] = b[i].toCharArray();
//        }
//        // board에 존재하는 모든 타일
//        Set<Character> set = new HashSet<>();
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                if(board[i][j] != '.' && board[i][j] != '*') {
//                    set.add(board[i][j]);
//                }
//            }
//        }
//
//        List<Character> ans = new ArrayList<>();
//        // 순서를 찾기 위한 배열
//        int[] seq = new int[26];
//        while(true) {
//            List<Character> resList = new ArrayList<>();
//            List<Point> pointList = new ArrayList<>();
//            for(int i = 0; i < n; i++) {
//                for(int j = 0; j < m; j++) {
//                    if(board[i][j] != '.' && board[i][j] != '*') {
//                        Point res = bfs(i, j, n, m, board);
//                        if(res != null) {
//                            pointList.add(res);
//                            pointList.add(new Point(i, j, -1));
//                            resList.add(board[i][j]);
//                            // 아예 못 가게 함
//                            board[i][j] = '*';
//                            board[res.x][res.y] = '*';
//                        }
//                    }
//                }
//            }
//            if(resList.size() == 0) break;
//            for(Point p : pointList) {
//                board[p.x][p.y] = '.';
//            }
////            for(int i = 0; i < n; i++) {
////                for(int j = 0; j < m; j++) {
////                    System.out.print(board[i][j] + " ");
////                }
////                System.out.println();
////            }
////            System.out.println();
//            Collections.sort(resList);
//            ans.addAll(resList);
//        }
//
//        if(set.size() != ans.size()) return "IMPOSSIBLE";
//        else {
//            String answer = "";
//            for(char c : ans) {
//                answer += c;
//            }
//            return answer;
//        }
//    }
//
//    public Point bfs(int x, int y, int n, int m, char[][] board) {
//        // 상 우 하 좌
//        int[] dx = {-1, 0, 1, 0};
//        int[] dy = {0, 1, 0, -1};
//        Queue<Point> q = new LinkedList<>();
//        // d -> 방향이 꺾인 횟수를 담음
//        int[][] d = new int[n][m];
//        d[x][y] = 1;
//        q.add(new Point(x, y, -1));
//        while(!q.isEmpty()) {
//            Point now = q.poll();
//            for(int i = 0; i < 4; i++) {
//                int nx = now.x + dx[i];
//                int ny = now.y + dy[i];
//                // 영역 밖
//                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
//                // 이미 왔던 곳 or 못 감 (벽 or 다른 알파벳)
//                if(d[nx][ny] != 0 || !(board[nx][ny] == '.' || board[nx][ny] == board[x][y])) continue;
//                // 방향을 3번 이상 회전하는 경우
//                if(d[now.x][now.y] == 2 && now.d != i) continue;
//                // 2회 방향 회전 이내로 같은 알파벳을 찾음
//                if(board[nx][ny] == board[x][y]) return new Point(nx, ny, -1);
//
//                if(now.d == i || now.d == -1) { // 이전 진행 방향과 다음 진행 방향이 같은 경우
//                    d[nx][ny] = d[now.x][now.y];
//                } else { // 이전 진행 방향과 다음 진행 방향이 다른 경우
//                    d[nx][ny] = d[now.x][now.y] + 1;
//                }
//                q.add(new Point(nx, ny, i));
////                for(int k = 0; k < n; k++) {
////                    for(int j = 0; j < m; j++) {
////                        System.out.print(d[k][j] + " ");
////                    }
////                    System.out.println();
////                }
////                System.out.println();
//            }
//        }
//
//        return null;
//    }
//}
//
//class Point {
//
//    int x, y, d;
//    Set<Character> set;
//
//    public Point(int x, int y, int d) {
//        this.x = x;
//        this.y = y;
//        this.d = d;
//        this.set = new HashSet<>();
//    }
//}

package 프로그래머스.level3.리틀_프렌즈_사천성;

import java.nio.charset.CharacterCodingException;
import java.util.*;

class Before_Solution {
    public String solution(int n, int m, String[] b) {
        // board -> 타일이 삭제되는 board
        char[][] board = new char[n][m];
        // origin -> 원본
        char[][] origin = new char[n][m];
        for(int i = 0; i < n; i++) {
            board[i] = b[i].toCharArray();
            origin[i] = b[i].toCharArray();
        }
        // board에 존재하는 모든 타일
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] != '.' && board[i][j] != '*') {
                    set.add(board[i][j]);
                }
            }
        }

        List<Character> ans = new ArrayList<>();
        // 순서를 찾기 위한 배열
        int[] seq = new int[26];
        int cnt = 0;
        while(true) {
            // 삭제된 타일을 저장하는 리스트
            List<Point> pointList = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(board[i][j] != '.' && board[i][j] != '*') {
                        Point res = bfs(i, j, n, m, board, origin);
                        if(res != null) {
                            // 삭제된 타일을 아예 못 가게 함
                            pointList.add(res);
                            pointList.add(new Point(i, j, -1));
                            board[i][j] = '*';
                            board[res.x][res.y] = '*';
                            cnt++;
                        }
                    }
                }
            }
            if(cnt == 0) break;
            // 삭제된 타일을 빈칸으로 변경
            for(Point p : pointList) {
                board[p.x][p.y] = '.';
            }
        }

        if(set.size() != ans.size()) return "IMPOSSIBLE";
        else {
            String answer = "";
            for(char c : ans) {
                answer += c;
            }
            return answer;
        }
    }

    public void makeSeq(int[] seq, char me, Set<Character> set) {

    }

    public Point bfs(int x, int y, int n, int m, char[][] board, char[][] origin) {
        // 상 우 하 좌
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Point> q = new LinkedList<>();
        // d -> 방향이 꺾인 횟수를 담음
        int[][] d = new int[n][m];
        d[x][y] = 1;
        q.add(new Point(x, y, -1));
        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                // 영역 밖
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 이미 왔던 곳 or 못 감 (벽 or 다른 알파벳)
                if(d[nx][ny] != 0 || !(board[nx][ny] == '.' || board[nx][ny] == board[x][y])) continue;
                // 방향을 3번 이상 회전하는 경우
                if(d[now.x][now.y] == 2 && now.d != i) continue;
                // 2회 방향 회전 이내로 같은 알파벳을 찾음
                if(board[nx][ny] == board[x][y]) return new Point(nx, ny, -1, now.set);

                if(now.d == i || now.d == -1) { // 이전 진행 방향과 다음 진행 방향이 같은 경우
                    d[nx][ny] = d[now.x][now.y];
                } else { // 이전 진행 방향과 다음 진행 방향이 다른 경우
                    d[nx][ny] = d[now.x][now.y] + 1;
                }
                q.add(new Point(nx, ny, i, now.set, origin[now.x][now.y]));
            }
        }
        return null;
    }
}

class Point {

    int x, y, d;
    Set<Character> set;

    public Point(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.set = new HashSet<>();
    }

    public Point(int x, int y, int d, Set<Character> set) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.set = new HashSet<>(set);
    }

    public Point(int x, int y, int d, Set<Character> set, char alpha) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.set = new HashSet<>(set);
        this.set.add(alpha);
    }
}