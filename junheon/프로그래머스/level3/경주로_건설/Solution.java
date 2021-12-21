package 프로그래머스.level3.경주로_건설;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/67259
 * 풀이: https://programmers.co.kr/questions/23781
 * 알고리즘: BFS 변형
 * 시간복잡도: ???
 */

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][][] visit = new boolean[n][n][4];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, -1, 0));
        visit[0][0][0] = visit[0][0][1] = visit[0][0][2] = visit[0][0][3] = true;
        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            Node now = q.poll();
            if(now.x == n - 1 && now.y == n - 1) ans = Math.min(ans, now.c);
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(board[nx][ny] == 1) continue;
                int nc = now.c + 100;
                if(now.d != -1 && now.d != i) nc += 500;
                if(!visit[nx][ny][i] || nc <= board[nx][ny]) { // 이해 안 됨
                    visit[nx][ny][i] = true;
                    board[nx][ny] = nc;
                    q.add(new Node(nx, ny, i, nc));
                }
            }
        }
        return ans;
    }
}

class Node {
    // d: 방향, c: 비용
    int x, y, d, c;

    public Node(int x, int y, int d, int c) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.c = c;
    }
}