package PS_2021.프로그래머스.level3.블록_이동하기;

import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int[][] d = new int[n][n];
        boolean[][][] visit = new boolean[n][n][4];
        Queue<Robot> q = new LinkedList<>();
        // 상 하 좌 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        q.add(new Robot(new Point(0, 0), new Point(0, 1)));
        q.add(new Robot(new Point(0, 1), new Point(0, 0)));
        d[0][0] = d[0][1] = 1;
        visit[0][0][2] = visit[0][1][3] = true;
        while(!q.isEmpty()) {
            Robot robot = q.poll();
            Point head = robot.head;
            Point tail = robot.tail;
            int dir = direction(head, tail);
            System.out.println(dir);
            int x = head.x;
            int y = head.y;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            int dist = Math.max(d[head.x][head.y], d[tail.x][tail.y]) + 1;
            if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if(board[nx][ny] == 0 && !visit[nx][ny][dir]) {
                    if(d[nx][ny] == 0 || dist <= d[nx][ny]) {
                        q.add(new Robot(new Point(nx, ny), head));
                        q.add(new Robot(head, new Point(nx, ny)));
                        d[nx][ny] = dist;
                        visit[nx][ny][dir] = true;
                    }
                }
            }

            if(dir == 0) { // 상
                if(y - 1 >= 0 && board[x][y - 1] == 0 && board[x + 1][y - 1] == 0) { // 좌
                    if(!visit[x + 1][y - 1][2] && (d[x + 1][y - 1] == 0 || dist <= d[x + 1][y - 1])) {
                        q.add(new Robot(new Point(x + 1, y - 1), tail));
                        q.add(new Robot(tail, new Point(x + 1, y - 1)));
                        d[x + 1][y - 1] = dist;
                        visit[x + 1][y - 1][2] = true;
                    }
                }
                if(y + 1 < n && board[x][y + 1] == 0 && board[x + 1][y + 1] == 0) { // 우
                    if(!visit[x + 1][y + 1][3] && (d[x + 1][y + 1] == 0 || dist <= d[x + 1][y + 1])) {
                        q.add(new Robot(new Point(x + 1, y + 1), tail));
                        q.add(new Robot(tail, new Point(x + 1, y + 1)));
                        d[x + 1][y + 1] = dist;
                        visit[x + 1][y + 1][3] = true;
                    }
                }
            } else if(dir == 1) { // 하
                if(y - 1 >= 0 && board[x][y - 1] == 0 && board[x - 1][y - 1] == 0) { // 좌
                    if(!visit[x - 1][y - 1][2] && (d[x - 1][y - 1] == 0 || dist <= d[x - 1][y - 1])) {
                        q.add(new Robot(new Point(x - 1, y - 1), tail));
                        q.add(new Robot(tail, new Point(x - 1, y - 1)));
                        d[x - 1][y - 1] = dist;
                        visit[x - 1][y - 1][2] = true;
                    }
                }
                if(y + 1 < n && board[x][y + 1] == 0 && board[x - 1][y + 1] == 0) { // 우
                    if(!visit[x - 1][y + 1][3] && (d[x - 1][y + 1] == 0 || dist <= d[x - 1][y + 1])) {
                        q.add(new Robot(new Point(x - 1, y + 1), tail));
                        q.add(new Robot(tail, new Point(x - 1, y + 1)));
                        d[x - 1][y + 1] = dist;
                        visit[x - 1][y + 1][3] = true;
                    }
                }
            } else if(dir == 2) { // 좌
                if(x - 1 >= 0 && board[x - 1][y] == 0 && board[x - 1][y + 1] == 0) { // 상
                    if(!visit[x - 1][y + 1][0] && (d[x - 1][y + 1] == 0 || dist <= d[x - 1][y + 1])) {
                        q.add(new Robot(new Point(x - 1, y + 1), tail));
                        q.add(new Robot(tail, new Point(x - 1, y + 1)));
                        d[x - 1][y + 1] = dist;
                        visit[x - 1][y + 1][0] = true;
                    }
                }
                if(x + 1 < n && board[x + 1][y] == 0 && board[x + 1][y + 1] == 0) { // 하
                    if(!visit[x + 1][y + 1][1] && (d[x + 1][y + 1] == 0 || dist <= d[x + 1][y + 1])) {
                        q.add(new Robot(new Point(x + 1, y + 1), tail));
                        q.add(new Robot(tail, new Point(x + 1, y + 1)));
                        d[x + 1][y + 1] = dist;
                        visit[x + 1][y + 1][1] = true;
                    }
                }
            } else if(dir == 3) { // 우
                if(x - 1 >= 0 && board[x - 1][y] == 0 && board[x - 1][y - 1] == 0) { // 상
                    if(!visit[x - 1][y - 1][0] && (d[x - 1][y - 1] == 0 || dist <= d[x - 1][y - 1])) {
                        q.add(new Robot(new Point(x - 1, y - 1), tail));
                        q.add(new Robot(tail, new Point(x - 1, y - 1)));
                        d[x - 1][y - 1] = dist;
                        visit[x - 1][y - 1][0] = true;
                    }
                }
                if(x + 1 < n && board[x + 1][y] == 0 && board[x + 1][y - 1] == 0) { // 하
                    if(!visit[x + 1][y - 1][1] && (d[x + 1][y - 1] == 0 || dist <= d[x + 1][y - 1])) {
                        q.add(new Robot(new Point(x + 1, y - 1), tail));
                        q.add(new Robot(tail, new Point(x + 1, y - 1)));
                        d[x + 1][y - 1] = dist;
                        visit[x + 1][y - 1][1] = true;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }

        return d[n - 1][n - 1] - 1;
    }

    // 상 = 0, 하 = 1, 좌 = 2, 우 = 3
    public int direction(Point head, Point tail) {
        int dx = head.x - tail.x;
        int dy = head.y - tail.y;
        if(dy == 0) {
            if(dx < 0) return 0;
            else return 1;
        }
        else {
            if(dy < 0) return 2;
            else return 3;
        }
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Robot {
    Point head, tail;

    public Robot(Point head, Point tail) {
        this.head = head;
        this.tail = tail;
    }
}
