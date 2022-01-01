package 프로그래머스.lv3.경주로건설;

import java.util.*;

class Solution {
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, 1, 0 ,-1};
    public int n, min = Integer.MAX_VALUE;
    public boolean[][][] visit;
    public int solution(int[][] board) {
        n = board.length;
        visit = new boolean[n][n][4];

        bfs(board);
        return min;
    }
    public void bfs(int[][] board){
        Queue<track> queue = new LinkedList<>();
        queue.add(new track(0, 0, 0, -1));
        visit[0][0][0] = visit[0][0][1] = visit[0][0][2] = visit[0][0][3] = true;

        while(!queue.isEmpty()){
            track now = queue.poll();

            if(now.x == n-1 && now.y == n-1)
                min = Math.min(min, now.cost);

            for(int i=0; i<4; i++){
                int next_x = now.x + dx[i];
                int next_y = now.y + dy[i];
                int next_dir = i;
                int next_cost = now.cost;

                if(next_x < 0 || next_y < 0 || next_x >= n || next_y >= n || board[next_x][next_y] == 1)
                    continue;

                if(now.dir == -1 || now.dir == next_dir) { //직진
                    next_cost += 100;
                } else { //코너 600원 뒤진다 진짜로
                    next_cost += 600;
                }

                if(!visit[next_x][next_y][i] || board[next_x][next_y] >= next_cost) {
                    visit[next_x][next_y][i] = true;
                    board[next_x][next_y] = next_cost;
                    queue.add(new track(next_x, next_y, next_cost, next_dir));
                }

            }
        }
    }
}
class track{
    int x;
    int y;
    int cost;
    int dir;

    public track(int x, int y, int cost, int dir){
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dir = dir;
    }
}